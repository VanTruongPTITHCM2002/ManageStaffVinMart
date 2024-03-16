package PTITHCM.CONTROLLER;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import PTITHCM.BEAN.LichLamViec;

@Transactional
@Controller
public class UserLichLamViec {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("user/lichlamviec")
	public String hienThiBangLuong( HttpSession br,ModelMap model) {
		Session session = factory.getCurrentSession();
		String userid = (String)br.getAttribute("user-nv");
		String hql = "From LichLamViec where manhanvien.maNV = ?";
		Query query = session.createQuery(hql).setParameter(0, userid);
		List<LichLamViec> list_work = query.list();
		model.addAttribute("user_llv", list_work);
		return "user/lichlamviec";
	}
}
