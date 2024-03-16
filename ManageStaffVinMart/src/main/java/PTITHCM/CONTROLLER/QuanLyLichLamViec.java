package PTITHCM.CONTROLLER;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import PTITHCM.BEAN.HopDongLaoDong;
import PTITHCM.BEAN.LichLamViec;
import PTITHCM.BEAN.TaiKhoan;
@Controller
@Transactional
public class QuanLyLichLamViec {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("quanlylichlamviec")
	public String getLichLamViec(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "From LichLamViec where manhanvien.matk.quyen.tenQuyen = ?";
		Query query = session.createQuery(hql).setParameter(0, "users");
		List<LichLamViec> lichlamviec = query.list();
		model.addAttribute("llv", lichlamviec);
		hql = "From HopDongLaoDong";
		 query = session.createQuery(hql);
		List<HopDongLaoDong>list1 = query.list();
		model.addAttribute("hdld", list1);		
		return "lichlamviec";
	}
	
	@RequestMapping(value = "quanlylichlamviec.html#inform",method = RequestMethod.GET)
	public String themLichLamViec(ModelMap model) {
		model.addAttribute("llv", new LichLamViec());
		return "lichlamviec";
	}
	private boolean check_GioNgay(String id,Date datework,Time start,Time end) {
		Session session = factory.getCurrentSession();
		String hql = "From LichLamViec where manhanvien.maNV = ?";
		Query query = session.createQuery(hql).setParameter(0, id);
		List<LichLamViec> lichlamviec = query.list();
		for (LichLamViec p :lichlamviec) {
			if(p.getNgayLam().equals(datework)) {
				return false;
			}
		}
		return true;
	}
	@RequestMapping(value = "quanlylichlamviec/create-lichlamviec.html",params = "btncreate-lichlamviec",method = RequestMethod.POST)
	public String themLicLamViec1(RedirectAttributes redirectAttributes,@ModelAttribute("llv") LichLamViec lichlamviec,
			@RequestParam("manhanvien.maNV") String id) throws ParseException {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		int hour1 = lichlamviec.getGioBatDau().getHours();
		int hour2 = lichlamviec.getGioKetThuc().getHours();
		int minute1 = lichlamviec.getGioBatDau().getMinutes();
		int minute2 = lichlamviec.getGioKetThuc().getMinutes();
		int second1 = lichlamviec.getGioBatDau().getSeconds();
		int second2 = lichlamviec.getGioKetThuc().getSeconds();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = sdf.format(date);
		Date newDate = sdf.parse(formattedDate);
		if (lichlamviec.getNgayLam().compareTo(newDate) >= 0) {
			if (hour1 > hour2) {
				redirectAttributes.addFlashAttribute("mess4", "Không được chọn giờ bắt đầu lớn hơn giờ kết thúc");
				return "redirect:/quanlylichlamviec.html";
			}
			if (hour1 == 7 && hour2 == 12) {
				if ((minute1 != 0 && second1 != 0) || (minute1 == 0 && second1 != 0)
						|| (minute1 != 0 && second1 == 0)) {
					redirectAttributes.addFlashAttribute("mess4", "Vui lòng chọn đúng khung giờ");
					return "redirect:/quanlylichlamviec.html";
				} else if ((minute2 != 0 && second2 != 0) || (minute2 == 0 && second2 != 0)
						|| (minute2 != 0 && second2 == 0)) {
					redirectAttributes.addFlashAttribute("mess4", "Vui lòng chọn đúng khung giờ");
					return "redirect:/quanlylichlamviec.html";
				}
				else {
					boolean flag = check_GioNgay(id,lichlamviec.getNgayLam(),lichlamviec.getGioBatDau(),lichlamviec.getGioKetThuc());
					if(flag == false) {
						redirectAttributes.addFlashAttribute("mess4", "Nhân viên đã có lịch trong ngày đó");
						return "redirect:/quanlylichlamviec.html";
					}
				}
			} else if (hour2 == 21 && hour1 == 13) {
				if ((minute1 != 0 && second1 != 0) || (minute1 == 0 && second1 != 0)
						|| (minute1 != 0 && second1 == 0)) {
					redirectAttributes.addFlashAttribute("mess4", "Vui lòng chọn đúng khung giờ");
					return "redirect:/quanlylichlamviec.html";
				} else if ((minute2 != 0 && second2 != 0) || (minute2 == 0 && second2 != 0)
						|| (minute2 != 0 && second2 == 0)) {
					redirectAttributes.addFlashAttribute("mess4", "Vui lòng chọn đúng khung giờ");
					return "redirect:/quanlylichlamviec.html";
				}
				else {
					boolean flag = check_GioNgay(id,lichlamviec.getNgayLam(),lichlamviec.getGioBatDau(),lichlamviec.getGioKetThuc());
					if(flag == false) {
						redirectAttributes.addFlashAttribute("mess4", "Nhân viên đã có lịch trong ngày đó");
						return "redirect:/quanlylichlamviec.html";
					}
				}
			} else {
				redirectAttributes.addFlashAttribute("mess4", "Vui lòng chọn đúng khung giờ");
				return "redirect:/quanlylichlamviec.html";
			}
		} else {
			redirectAttributes.addFlashAttribute("mess4", "Vui lòng không chọn ngày trong quá khứ");
			return "redirect:/quanlylichlamviec.html";
		}
		 try {
			 	redirectAttributes.addFlashAttribute("mess4", "Thêm lịch làm việc thành công");
		        session.save(lichlamviec);				       
		        t.commit();
		    } catch (Exception e) {
		        e.printStackTrace();
		        t.rollback();
		    } finally {
		        session.close();
		    }
			
		    return "redirect:/quanlylichlamviec.html";
	}
}
