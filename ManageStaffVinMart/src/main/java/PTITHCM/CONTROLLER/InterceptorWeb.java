package PTITHCM.CONTROLLER;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import PTITHCM.BEAN.TaiKhoan;

public class InterceptorWeb extends HandlerInterceptorAdapter {
	  @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		  String requestURI = request.getRequestURI();
	        if (requestURI.startsWith("/admin")) {
	            HttpSession session = request.getSession();
	            if (session == null || session.getAttribute("user") == null) {
	                response.sendRedirect("/login");
	                return false;
	            }
	        }
	        return true;
	    }
}
