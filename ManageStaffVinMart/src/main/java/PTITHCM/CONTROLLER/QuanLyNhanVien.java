package PTITHCM.CONTROLLER;


import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import PTITHCM.BEAN.BangLuong;
import PTITHCM.BEAN.CTBANGLUONG;
import PTITHCM.BEAN.NhanVien;
import PTITHCM.BEAN.TaiKhoan;

@Controller
@Transactional
public class QuanLyNhanVien {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("pages-profile")
	public String staff(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "From NhanVien Where maNV != ?";
		Query query = session.createQuery(hql).setParameter(0, "NV001");
		List<NhanVien>list = query.list();
		model.addAttribute("nv",list);
		return "staff";
	}
	
	// Thêm nhân viên
	@RequestMapping(value = "pages-profile.html#inform", method = RequestMethod.GET)
	public String themnhanvien(ModelMap model) {
		model.addAttribute("nhanviencuahang",new NhanVien());
		return "staff";
	}
	
	public boolean checkNhanVien(NhanVien p) {
		Session session = factory.getCurrentSession();
		String hql = "From NhanVien Where maNV != ?";
		Query query = session.createQuery(hql).setParameter(0, "NV001");
		List<NhanVien>list = query.list();
		boolean c = true;
		for (NhanVien k: list) {
			if(k.getMaNV().equals(p.getMaNV())) {
				c = false;
			}
		}
		return c;
	}

	@RequestMapping(value = "pages-profile/add-staff.html",params = "btncreate-staff",method = RequestMethod.POST)
	public String themnhanvien(RedirectAttributes redirectAttributes, @ModelAttribute("nhanviencuahang") NhanVien nv) {
		Session session = factory.openSession();
		org.hibernate.Transaction t = session.beginTransaction();
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
	    int year = zonedDateTime.getYear();
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(nv.ngaySinh);
	    int year1 = calendar.get(Calendar.YEAR);
		if (year - year1 < 18) {
			redirectAttributes.addFlashAttribute("message", "Ngày tháng năm sinh không hợp lệ");
			return "redirect:/pages-profile.html";
		}
		try {
			session.save(nv);
			redirectAttributes.addFlashAttribute("message", "Thêm nhân viên thành công");
			t.commit();
		}catch(Exception e) {
			if(!checkNhanVien(nv)) {
				redirectAttributes.addFlashAttribute("message", "Mã nhân viên đã tồn tại");
				}			
			t.rollback();
		}
		DateFormat dt = null;
		dt = new SimpleDateFormat("dd/MM/yyyy");
		
		String hql = "INSERT INTO TaiKhoan(TENTK,MATKHAU,TRANGTHAI,MAQUYEN) VALUES (?,?,?,?)";
        SQLQuery  query1 = session.createSQLQuery(hql);
        query1.setParameter(0, nv.getMaNV());
        query1.setParameter(1, dt.format(nv.getNgaySinh()).toString().replace("/", ""));
        query1.setParameter(2, true);
        query1.setParameter(3, 2);
        int row = query1.executeUpdate();
		return "redirect:/pages-profile.html";
	}
	@RequestMapping(params = "btnupdate-staff",method = RequestMethod.POST)
	public String capnhatnv(RedirectAttributes redirectAttributes,@ModelAttribute("nhanviencuahang") NhanVien nv) {
		Session session = factory.openSession();
		String hql = "update NhanVien s set s.ho = ?, s.ten = ?, s.gioiTinh = ?,s.ngaySinh = ?,s.diaChi = ?,s.sdt=?,s.email = ? where s.maNV = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, nv.ho);
		query.setParameter(1, nv.ten);
		query.setParameter(2, nv.gioiTinh);
		query.setParameter(3, nv.ngaySinh);
		query.setParameter(4, nv.diaChi);
		query.setParameter(5, nv.sdt);
		query.setParameter(6, nv.email);
		query.setParameter(7, nv.getMaNV());
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
	    int year = zonedDateTime.getYear();
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(nv.ngaySinh);
	    int year1 = calendar.get(Calendar.YEAR);
		if (year - year1 < 18) {
			redirectAttributes.addFlashAttribute("message", "Ngày tháng năm sinh không hợp lệ");
			return "redirect:/pages-profile.html";
		}
		int row = query.executeUpdate();
		org.hibernate.Transaction t = session.beginTransaction();
		try {
			redirectAttributes.addFlashAttribute("message", "Cập nhật nhân viên thành công");
			t.commit();
		}catch(Exception e) {
			t.rollback();
		}
		return "redirect:/pages-profile.html";
	}
	
}
