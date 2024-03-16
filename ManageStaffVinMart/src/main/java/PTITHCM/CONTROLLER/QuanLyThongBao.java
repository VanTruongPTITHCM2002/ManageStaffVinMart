package PTITHCM.CONTROLLER;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import PTITHCM.BEAN.CTThongbao;
import PTITHCM.BEAN.HopDongLaoDong;
import PTITHCM.BEAN.NhanVien;
import PTITHCM.BEAN.TaiKhoan;
import PTITHCM.BEAN.ThongBao;
@Transactional
@Controller
public class QuanLyThongBao {

	@Autowired
	SessionFactory factory;
	@RequestMapping("thongbao")
	public String thongBao(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "From ThongBao";
		Query query = session.createQuery(hql);
		List<ThongBao>list = query.list();
		model.addAttribute("tb",list);
		 session = factory.getCurrentSession();
		 hql = "From TaiKhoan where quyen.tenQuyen = ? ORDER BY nhanvien.maNV";
		 query = session.createQuery(hql).setParameter(0, "users");
		List<TaiKhoan>list2 = query.list();
		model.addAttribute("list2",list2);
		return "thongbao";
	}
	
	@RequestMapping(value = "thongbao.html#inform",method = RequestMethod.GET)
	public String themthongbao(ModelMap model) {
		model.addAttribute("thongbaonhanvien",new ThongBao());
		return "thongbao";
	}
	
	public boolean checkThongBao(ThongBao p) {
		Session session = factory.getCurrentSession();
		String hql = "From ThongBao";
		Query query = session.createQuery(hql);
		List<ThongBao>list = query.list();
		boolean c = true;
		for (ThongBao k: list) {
			if(k.getNoiDung().equals(p.getNoiDung())) {
				c = false;
			}
		}
		return c;
	}
	@RequestMapping(params = "btncreate-thongbao",method = RequestMethod.POST)
	public String themnhanvien(RedirectAttributes redirectAttributes, @ModelAttribute("thongbaonhanvien") ThongBao cttb) throws ParseException {
		Session session = factory.openSession();
		org.hibernate.Transaction t = session.beginTransaction();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = sdf.format(date);
		Date newDate = sdf.parse(formattedDate);
		if (!cttb.getNgayTB().equals(newDate)) {
			redirectAttributes.addFlashAttribute("thongbao","Vui lòng ngày tạo thông báo phải trùng với ngày hiện tại");
			return "redirect:/thongbao.html";
		}
		if(!checkThongBao(cttb)) {
			redirectAttributes.addFlashAttribute("thongbao", "Nội dung thông báo đã tồn tại trong hôm nay rồi");
			}	
		try {
			session.save(cttb);
			redirectAttributes.addFlashAttribute("thongbao", "Thêm thông báo thành công");
			t.commit();
		}catch(Exception e) {	
			e.printStackTrace();
			t.rollback();
		}
		finally {
			session.close();
		}
		return "redirect:/thongbao.html";
	}
	
	@RequestMapping(value = "thongbao.html#inform2",method = RequestMethod.GET)
	public String guithongbao(ModelMap model) {
		model.addAttribute("guithongbaonhanvien",new CTThongbao());
		return "thongbao";
	}
	
	@RequestMapping(params = "btncreate-guithongbao",method = RequestMethod.POST)
	public String themnhanvien(RedirectAttributes redirectAttributes, @ModelAttribute("guithongbaonhanvien") CTThongbao cttb,
			@RequestParam("manhanvienthongbao.maNV") String id) {
			Session session = factory.openSession();
			org.hibernate.Transaction t = session.beginTransaction();
		try {
			session.save(cttb);
			redirectAttributes.addFlashAttribute("thongbao", "Gửi thành công cho nhân viên" );
			t.commit();
		}catch(Exception e) {			
			redirectAttributes.addFlashAttribute("thongbao", "Không thể gửi thông báo này do đã gửi nhân viên này đã nhận rồi" );
			t.rollback();
		}
		finally {
			session.close();
		}
		return "redirect:/thongbao.html";
	}

}
