package PTITHCM.CONTROLLER;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrangChu {
	@RequestMapping("homepage1")
	public String homePage2() {
		return "homepage2";
	}
}
