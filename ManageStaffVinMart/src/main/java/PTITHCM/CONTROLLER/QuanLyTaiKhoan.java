package PTITHCM.CONTROLLER;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import PTITHCM.BEAN.Quyen;
import PTITHCM.BEAN.NhanVien;
import PTITHCM.BEAN.TaiKhoan;
@Transactional
@Controller
public class QuanLyTaiKhoan {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("manageaccount")
	public String account(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "From TaiKhoan where quyen.tenQuyen = ? ORDER BY nhanvien.maNV";
		Query query = session.createQuery(hql).setParameter(0, "users");
		List<TaiKhoan>list = query.list();
		model.addAttribute("tk",list);
		return "homepage";
	}
	
		
	@RequestMapping(params = "btnupdate-account",method = RequestMethod.POST)
	public String capnhatnv(RedirectAttributes redirectAttributes,@RequestParam("id") String id, @RequestParam("status") Boolean trangthai) {
		Session session = factory.openSession();
		String hql = "update TaiKhoan s set s.trangthai = ? where s.nhanvien.maNV = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, trangthai);
		query.setParameter(1, id);
		
		int row = query.executeUpdate();
		org.hibernate.Transaction t = session.beginTransaction();
		try {
			redirectAttributes.addFlashAttribute("mess", "Tài khoản đã cập nhật thành công");
			t.commit();
		}catch(Exception e) {
			t.rollback();
		}
		return "redirect:/manageaccount.html";
	}
	@RequestMapping(params = "ResetPass",method = RequestMethod.POST)
	public String resetPassnv(RedirectAttributes redirectAttributes,@RequestParam("id") String id, int flag) {
		if (flag == 1) {
		Session session = factory.openSession();
		String hql = "update TaiKhoan s set s.matkhau = ? where s.nhanvien.maNV = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, 1);
		query.setParameter(1, id);
		
		int row = query.executeUpdate();
		org.hibernate.Transaction t = session.beginTransaction();
		try {
			redirectAttributes.addFlashAttribute("mess", "Tài khoản đã reset mật khẩu thành công");
			t.commit();
		}catch(Exception e) {
			t.rollback();
		}
	}
		return "redirect:/manageaccount.html";
	}
}
