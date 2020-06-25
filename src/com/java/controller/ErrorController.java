package com.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myclass.dto.LoginDTO;
import com.myclass.util.PathConstants;
import com.myclass.util.UrlConstants;

@WebServlet(urlPatterns = {UrlConstants.URL_ERROR_403})
public class ErrorController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		HttpSession session = req.getSession();
		LoginDTO login = (LoginDTO) session.getAttribute("USER_LOGIN");
		req.setAttribute("login", login);
		switch(action) {
		case UrlConstants.URL_ERROR_403:
			req.getRequestDispatcher(PathConstants.PATH_ERROR_403).forward(req, resp);
			break;
		}
	}
}
