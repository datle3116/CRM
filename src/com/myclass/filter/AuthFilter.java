package com.myclass.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myclass.dto.LoginDTO;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		
		String action = req.getServletPath();
		if(action.startsWith("/login")) {
			chain.doFilter(request, response);
			return;
		}
		System.out.println("OK");
		
		/*
		 * Kiểm tra đăng nhập:
		 * 1. Chưa đăng nhập hoặc đăng xuất -> đưa về lại trang login
		 * 2. Đã đăng nhập -> tiếp tục mắt xích tiếp theo
		 */
		HttpSession session = req.getSession();
		if(session == null || session.getAttribute("USER_LOGIN") == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		
		LoginDTO login = (LoginDTO) session.getAttribute("USER_LOGIN");
		if(login.getRoleName().equals("ROLE_MANAGER") && action.startsWith("/role")) {
			resp.sendRedirect(req.getContextPath() + "/error/403");
			return;
		} else if(login.getRoleName().equals("ROLE_USER") && (action.startsWith("/role") || action.startsWith("/user") || action.startsWith("/job/delete") || action.startsWith("/job/edit"))) {
			resp.sendRedirect(req.getContextPath() + "/error/403");
			return;
		}
		chain.doFilter(request, response);
		
	}
	
}
