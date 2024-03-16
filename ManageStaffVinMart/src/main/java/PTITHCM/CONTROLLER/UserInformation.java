package PTITHCM.CONTROLLER;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import PTITHCM.BEAN.NhanVien;

@Transactional
@Controller
public class UserInformation {
	@Autowired
	SessionFactory factory;
	@RequestMapping("user/inform_staff")
	public String staff(ModelMap model,HttpSession br) {
		Session session = factory.getCurrentSession();
		String userid = (String)br.getAttribute("user-nv");
		String hql = "From NhanVien Where maNV = ?";
		Query query = session.createQuery(hql).setParameter(0, userid);
		List<NhanVien>list = query.list();
		model.addAttribute("nv",list);
		return "user/inform_staff";
	}
	
	@RequestMapping(params = "btnupdate-employee",method = RequestMethod.POST)
	public String capnhatnv(RedirectAttributes redirectAttributes,@ModelAttribute("nhanviencuahang") NhanVien nv,HttpSession br) {
		Session session = factory.openSession();
		String userid = (String)br.getAttribute("user-nv");
		String hql = "update NhanVien s set s.ho = ?, s.ten = ?, s.gioiTinh = ?,s.ngaySinh = ?,s.diaChi = ?,s.sdt=?,s.email = ? where s.maNV = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, nv.ho);
		query.setParameter(1, nv.ten);
		query.setParameter(2, nv.gioiTinh);
		query.setParameter(3, nv.ngaySinh);
		query.setParameter(4, nv.diaChi);
		query.setParameter(5, nv.sdt);
		query.setParameter(6, nv.email);
		query.setParameter(7, userid);
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
	    int year = zonedDateTime.getYear();
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(nv.ngaySinh);
	    int year1 = calendar.get(Calendar.YEAR);
		if (year - year1 < 18) {
			redirectAttributes.addFlashAttribute("tin_nhan", "Ngày tháng năm sinh không hợp lệ");
			return "redirect:/user/inform_staff.html";
		}
		int row = query.executeUpdate();
		org.hibernate.Transaction t = session.beginTransaction();
		try {
			redirectAttributes.addFlashAttribute("tin_nhan", "Cập nhật nhân viên thành công");
			t.commit();
		}catch(Exception e) {
			t.rollback();
		}
		return "redirect:/user/inform_staff.html";
	}
}
