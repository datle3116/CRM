package com.java.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.connection.JDBCConnection;
import com.myclass.dto.LoginDTO;
import com.myclass.util.PathConstants;
import com.myclass.util.UrlConstants;

@WebServlet(urlPatterns = UrlConstants.URL_HOME)
public class HomeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		LoginDTO login = (LoginDTO) session.getAttribute("USER_LOGIN");
		req.setAttribute("login", login);
		req.getRequestDispatcher(PathConstants.PATH_HOME).forward(req, resp);
		
		
	}
}
