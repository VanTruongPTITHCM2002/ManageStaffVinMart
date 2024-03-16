package PTITHCM.CONTROLLER;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserHome {
	@RequestMapping("user/trangchu")
	public String trangChu() {
		return "user/trangchu";
	}
}
