package PTITHCM.CONTROLLER;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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

import PTITHCM.BEAN.BangLuong;
import PTITHCM.BEAN.CTBANGLUONG;
import PTITHCM.BEAN.CTBANGLUONGUPDATE;
import PTITHCM.BEAN.ChamCong;
import PTITHCM.BEAN.HopDongLaoDong;
import PTITHCM.BEAN.LichLamViec;
import PTITHCM.BEAN.NhanVien;

@Controller
@Transactional
public class QuanLyBangLuong {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("form-basic")
	public String salary(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "From CTBANGLUONG";
		Query query = session.createQuery(hql);
		List<CTBANGLUONG>list = query.list();
		hql = "From HopDongLaoDong";
		query = session.createQuery(hql);
		List<HopDongLaoDong> hdld = query.list();
		model.addAttribute("chitietbangluong",list);
		model.addAttribute("hdld", hdld);
		return "salary";
	}
	
	@RequestMapping(value = "form-basic.html#inform",method = RequestMethod.GET)
	public String themluong(ModelMap model) {
		 model.addAttribute("chitietbangluong", new CTBANGLUONG());
		return "salary";
	}
	
	public String kiemTraThoiGian(String id,int thang,int nam) {
		String chuoi = "";
		Session session = factory.getCurrentSession();
		String hql = "From HopDongLaoDong where manv.maNV = ?";
		Query query = session.createQuery(hql).setParameter(0, id);
		List <HopDongLaoDong> k = query.list();
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);
		if (nam < year) {
			chuoi = "Năm không hợp lệ";
			return chuoi;
		}
		else if (nam == year) {
			if (thang > (month + 1)) {
				chuoi = "Tháng không hợp lệ";
				return chuoi;
			}
		}
		for(HopDongLaoDong q: k) {
			Calendar calendar3 = Calendar.getInstance();
			calendar3.setTime(q.getNgayBatDau());
			int year3 = calendar3.get(Calendar.YEAR);
			int month3 = calendar3.get(Calendar.MONTH);
			
			Calendar calendar4 = Calendar.getInstance();
			calendar4.setTime(q.getNgayBatDau());
			int year4 = calendar4.get(Calendar.YEAR);
			int month4 = calendar4.get(Calendar.MONTH);
			
			if (nam >= year3 && nam <= year4) {
				if (thang < (month3 + 1) || (thang > (month4 + 1) && (nam > year3))) {
					chuoi = "Tháng không hợp lệ vì năm ngoài hợp đồng quy định";
				}
			}
			else {
				chuoi = "Năm không hợp lệ vì năm ngoài hợp đồng quy định";
			}
			
		}
		return chuoi;
	}
	public boolean checkTrung(String id, int month, int year) {
		Session session = factory.getCurrentSession();
		String hql = "From CTBANGLUONG where nhanvienluong.maNV = ?";
		Query query = session.createQuery(hql).setParameter(0, id);
		List<CTBANGLUONG> user_bl= query.list();
		for (CTBANGLUONG c : user_bl) {
			if (year == c.getNam()) {
				if(month == c.getThang()) {
					return false;
				}
			}
		}
		return true;
	}
	public int checkTrangThaiDiLamTre(String id, int month) {
		Session session = factory.getCurrentSession();
		String hql = "From ChamCong where lichlamviec.manhanvien.maNV = ? and month(ngaycc) = ?";
		Query query = session.createQuery(hql).setParameter(0, id);
		query.setParameter(1, month);
		List<ChamCong> user_llv = query.list();
		int dem = 0;
		for (ChamCong c: user_llv) {
			 
				if(c.getTrangthai() == 1) {
					dem = dem + 1;
				}
			
		}
		return dem;
	}
	public int checkTrangThaiNghiLam(String id, int month) {
		Session session = factory.getCurrentSession();
		String hql = "From ChamCong where lichlamviec.manhanvien.maNV = ? and month(ngaycc) = ?";
		Query query = session.createQuery(hql).setParameter(0, id);
		query.setParameter(1, month);
		List<ChamCong> user_llv = query.list();
		int dem = 0;
		for (ChamCong c: user_llv) {
			
				if(c.getTrangthai() == -1) {
					dem = dem + 1;
				}
			
		}
		return dem;
	}
	public int checkLuong(String id, int month, int year) {
		Session session = factory.getCurrentSession();
		String hql = "From ChamCong where lichlamviec.manhanvien.maNV = ? and year(ngaycc) = ? and month(ngaycc)=?";
		Query query = session.createQuery(hql).setParameter(0, id);
		query.setParameter(1, year);
		query.setParameter(2, month);
		List<ChamCong> check_Luong = query.list();
		int count = check_Luong.size();
		return count;
	}
	public int getTongTien(String id,int year,int month,int num) throws ParseException {
		Session session = factory.getCurrentSession();
		String hql = "From HopDongLaoDong where manv.maNV = ?";
		Query query = session.createQuery(hql).setParameter(0, id);
		List<HopDongLaoDong> check_Luong = query.list();
		int sum = 0;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = sdf.format(date);
		Date newDate = sdf.parse(formattedDate);
		for(HopDongLaoDong c: check_Luong) {
				if(c.getNgayKetThuc().compareTo(newDate) > 0) {
					sum = sum + c.getBl().getBacluong() * c.getBl().getLuongcoban();
				}
		}
		return (sum * num) / 30;
	}
	@RequestMapping(params = "btncreate-salary", method = RequestMethod.POST)
	public String themluong(RedirectAttributes redirectAttributes, @ModelAttribute("chitietbangluong") CTBANGLUONG ctluong,
			@RequestParam("nhanvienluong.maNV") String id) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		 Date currentDate = new Date();
	     Calendar calendar = Calendar.getInstance();
	     calendar.setTime(currentDate);

	        // Lấy số ngày trong tháng của ngày hiện tại
	     int lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

	        // Lấy ngày trong tháng
	     int currentDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
	     
	     if(lastDayOfMonth != currentDayOfMonth) {
	    	 redirectAttributes.addFlashAttribute("mess2", "Không thể tính lương do ngày hiện tại không là ngày cuối tháng");
			 return "redirect:/form-basic.html";
	     }
		String test = kiemTraThoiGian(id,ctluong.getThang(),ctluong.getNam());
		if (test.equals("Năm không hợp lệ") || test.equals("Tháng không hợp lệ")
				|| test.equals("Tháng không hợp lệ vì năm ngoài hợp đồng quy định") ||
				test.equals("Năm không hợp lệ vì năm ngoài hợp đồng quy định")) {
			redirectAttributes.addFlashAttribute("mess2",test);
			return "redirect:/form-basic.html";
		}
		if(!checkTrung(id,ctluong.getThang(),ctluong.getNam())) {
			redirectAttributes.addFlashAttribute("mess2", "Bạn đã tính lương tháng này rồi");
			 return "redirect:/form-basic.html";
		}
		int num = checkLuong(id,ctluong.getThang(),ctluong.getNam());
		
		 try {	
			 	//Đi trễ thì bị trừ 200.000/lần, nghỉ làm thì bị trừ 1.000.000/lần
			 	int ditre = checkTrangThaiDiLamTre(id,ctluong.getThang());
			 	int nghilam = checkTrangThaiNghiLam(id,ctluong.getThang());
			 	ctluong.setSotientamung(ditre * 200000 + nghilam * 1000000);
			 	int tong_tien = getTongTien(id,ctluong.getNam(),ctluong.getThang(),num);
			 	ctluong.setTongluong(tong_tien + ctluong.getPhucap()- ditre * 200000 - nghilam * 1000000);
			 	redirectAttributes.addFlashAttribute("mess2", "Tính lương thành công");
		        session.save(ctluong);
		        t.commit();
		      
		     
		       
		    } catch (Exception e) {
		        e.printStackTrace();
		        t.rollback();
		    } finally {
		        session.close();
		    }
		    return "redirect:/form-basic.html";
	}
	
}
