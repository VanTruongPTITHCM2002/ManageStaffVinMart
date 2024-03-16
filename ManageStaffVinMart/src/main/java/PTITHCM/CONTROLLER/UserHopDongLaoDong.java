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

import PTITHCM.BEAN.HopDongLaoDong;

@Transactional
@Controller
public class UserHopDongLaoDong {
	@Autowired
	SessionFactory factory;
	@RequestMapping("user/hopdonglaodong")
	public String hienThiBangLuong( HttpSession br,ModelMap model) {
		Session session = factory.getCurrentSession();
		String userid = (String)br.getAttribute("user-nv");
		String hql = "From HopDongLaoDong where manv.maNV = ?";
		Query query = session.createQuery(hql).setParameter(0, userid);
		List<HopDongLaoDong> hopdonglaodong = query.list();
		model.addAttribute("hdld", hopdonglaodong);
		return "user/hopdonglaodong";
	}
}
