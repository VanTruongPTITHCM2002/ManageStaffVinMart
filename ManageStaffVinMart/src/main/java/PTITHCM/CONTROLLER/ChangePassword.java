package PTITHCM.CONTROLLER;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import PTITHCM.BEAN.TaiKhoan;
@Transactional
@Controller
public class ChangePassword {
	@Autowired
	SessionFactory factory;
	@RequestMapping("doimatkhau")
	public String hienThiTrangDoiPass() {
		return "changepassword";
	}
	public boolean checkMatKhau(String pass) {
		Session session = factory.getCurrentSession();
		String hql = "from TaiKhoan tk where tk.nhanvien.maNV = ?";
		Query query = session.createQuery(hql).setParameter(0, "NV001");
		List<TaiKhoan> tk = query.list();
		if(tk.get(0).getMatkhau().trim().equals(pass)) {
			return true;
		}
		return false;
	}
	@RequestMapping(value = "doimatkhau.html",params = "change_pass",method = RequestMethod.POST)
	public String thucThi(RedirectAttributes redirectAttributes,HttpSession br,
			@RequestParam("password") String pass, @RequestParam("check_password") String pass2,@RequestParam("password_old") String 
			pass3) {
			Session session = factory.getCurrentSession();
			if(!checkMatKhau(pass3)) {
				redirectAttributes.addFlashAttribute("tin_nhan_pass","Sai mật khẩu");
				return "redirect:/doimatkhau.html";
			}
			if(!pass.equals(pass2)) {
				redirectAttributes.addFlashAttribute("tin_nhan_pass","Lỗi mật khẩu không trùng khớp");
				return "redirect:/doimatkhau.html";
			}
			
			
			session = factory.openSession();
			String hql = "update TaiKhoan tk set tk.matkhau = ? where tk.nhanvien.maNV = ?";
			Query query = session.createQuery(hql).setParameter(0, pass);
			query.setParameter(1, "NV001");
			int row = query.executeUpdate();
			org.hibernate.Transaction t = session.beginTransaction();
			try {
				redirectAttributes.addFlashAttribute("tin_nhan_pass","Đổi mật khẩu thành công");
				t.commit();
			}catch(Exception e) {
				t.rollback();
			}
			return "redirect:/doimatkhau.html";
	}
}
