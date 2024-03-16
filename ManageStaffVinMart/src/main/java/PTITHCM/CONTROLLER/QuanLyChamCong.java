package PTITHCM.CONTROLLER;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import PTITHCM.BEAN.ChamCong;


@Controller
@Transactional
public class QuanLyChamCong {
	@Autowired
	SessionFactory factory;
	@RequestMapping("starter-kit")
	public String attendCheck(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "From ChamCong";
		Query query = session.createQuery(hql);
		List<ChamCong>list = query.list();
		model.addAttribute("ctcc",list);
		return "attendcheck";
	}
}
