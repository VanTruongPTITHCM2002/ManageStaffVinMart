package PTITHCM.CONTROLLER;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import PTITHCM.BEAN.ChamCong;
import PTITHCM.BEAN.LichLamViec;
@Transactional
@Controller
public class UserChamCong {
	@Autowired
	SessionFactory factory;
	@RequestMapping("user/chamcong")
	public String hienThiBangChamCong( HttpSession br,ModelMap model) {
		Session session = factory.getCurrentSession();
		String userid = (String)br.getAttribute("user-nv");
		String hql = "From ChamCong where lichlamviec.manhanvien.maNV = ?";
		Query query = session.createQuery(hql).setParameter(0, userid);
		List<ChamCong> user_chamcong = query.list();
		model.addAttribute("user_chamcong", user_chamcong);
		return "user/chamcong";
	}
	public boolean checkChamCong(String id,Date d) {
		Session session = factory.getCurrentSession();
		String hql = "From ChamCong where lichlamviec.manhanvien.maNV = ?";
		Query query = session.createQuery(hql).setParameter(0, id);
		List<ChamCong> user_chamcong = query.list();
		for (ChamCong c : user_chamcong) {
			if (c.getNgaycc().equals(d)) {
				return false;
			}
		}
		return true;
	}
	@RequestMapping(value = "user/chamcong",params = "check_cham",method = RequestMethod.POST)
	public String chamCongNhanVien(RedirectAttributes rd,@RequestParam(value = "cham_cong_time") int flag,
			HttpSession br) throws ParseException {
		Session session = factory.getCurrentSession();
		String userid = (String)br.getAttribute("user-nv");
		String hql = "From LichLamViec where manhanvien.maNV = ?";
		Query query = session.createQuery(hql).setParameter(0, userid);
		List<LichLamViec> user_llv = query.list();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = sdf.format(date);
		Date newDate = sdf.parse(formattedDate);
		LocalTime currentTime = LocalTime.now();
		int hours = currentTime.getHour();
		int minutes = currentTime.getMinute();
		int seconds = currentTime.getSecond();

		Time time = new Time(hours, minutes, seconds);
		if(flag == 1) {
		if(!checkChamCong(userid,newDate)) {
			rd.addFlashAttribute("thong_bao_diem_danh", "Bạn đã điểm danh hôm nay rồi");
			return "redirect:/user/chamcong.html";
		}
		for (LichLamViec c :user_llv) {
			if(c.getNgayLam().equals(newDate)) {
				if(c.getGioBatDau().getHours() == hours) {
					if(c.getGioBatDau().getMinutes() + 30 < minutes ) {
				        // Sử dụng lớp Time
						
				        hql = "INSERT INTO ChamCong(NGAYCHAMCONG, GIOVAO,IDLLV,TRANGTHAI) VALUES (?,?,?,?)";
				        SQLQuery  query1 = session.createSQLQuery(hql);
				        query1.setParameter(0, c.getNgayLam());
				        query1.setParameter(1, time);
				        query1.setParameter(2, c.getIdllv());
				        query1.setParameter(3, 1);
					int row = query1.executeUpdate();
					
					
						rd.addFlashAttribute("thong_bao_diem_danh", "Bạn đã đi trễ");
						return "redirect:/user/chamcong.html";
					}
					else {
					        // Sử dụng lớp Time
						

					        hql = "INSERT INTO ChamCong(NGAYCHAMCONG, GIOVAO,IDLLV,TRANGTHAI) VALUES (?,?,?,?)";
					        SQLQuery  query1 = session.createSQLQuery(hql);
					        query1.setParameter(0, c.getNgayLam());
					        query1.setParameter(1, time);
					        query1.setParameter(2, c.getIdllv());
					        query1.setParameter(3, 0);
						int row = query1.executeUpdate();
						
						
						
						
							
							rd.addFlashAttribute("thong_bao_diem_danh","Bạn đã điểm danh thành công");
						
						return "redirect:/user/chamcong.html";
					}
				}
				else if(hours > c.getGioBatDau().getHours() && hours < c.getGioKetThuc().getHours()) {
					
					hql = "INSERT INTO ChamCong(NGAYCHAMCONG, GIOVAO,IDLLV,TRANGTHAI) VALUES (?,?,?,?)";
				        SQLQuery  query1 = session.createSQLQuery(hql);
				        query1.setParameter(0, c.getNgayLam());
				        query1.setParameter(1, time);
				        query1.setParameter(2, c.getIdllv());
				        query1.setParameter(3, 1);
					int row = query1.executeUpdate();
					
					rd.addFlashAttribute("thong_bao_diem_danh", "Bạn đã đi trễ");
					return "redirect:/user/chamcong.html";
				}
				else if (hours > c.getGioKetThuc().getHours()) {
					
					  hql = "INSERT INTO ChamCong(NGAYCHAMCONG, GIOVAO,IDLLV,TRANGTHAI) VALUES (?,?,?,?)";
				        SQLQuery  query1 = session.createSQLQuery(hql);
				        query1.setParameter(0, c.getNgayLam());
				        query1.setParameter(1, time);
				        query1.setParameter(2, c.getIdllv());
				        query1.setParameter(3, -1);
					int row = query1.executeUpdate();
					
					rd.addFlashAttribute("thong_bao_diem_danh", "Bạn đã nghỉ ngày hôm nay");
					return "redirect:/user/chamcong.html";
				}
				else {
					rd.addFlashAttribute("thong_bao_diem_danh", "Không thể điểm danh do chưa tới giờ điểm danh");
					return "redirect:/user/chamcong.html";
				}
			}
		}
		rd.addFlashAttribute("thong_bao_diem_danh","Hôm nay bạn không có lịch để điểm danh" );
		return "redirect:/user/chamcong.html";
	}	
		
		return "redirect:/user/chamcong.html";
	}
}
