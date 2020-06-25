package com.java.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.dao.RoleDAO;
import com.myclass.dto.LoginDTO;
import com.myclass.entity.Role;
import com.myclass.util.PathConstants;
import com.myclass.util.UrlConstants;

@WebServlet(urlPatterns = {UrlConstants.URL_ROLE_LIST, UrlConstants.URL_ROLE_EDIT, UrlConstants.URL_ROLE_ADD, UrlConstants.URL_ROLE_DELETE})
public class RoleController extends HttpServlet{
	RoleDAO roleDAO = null;
	@Override
	public void init() throws ServletException {
		roleDAO = new RoleDAO();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		HttpSession session = req.getSession();
		LoginDTO login = (LoginDTO) session.getAttribute("USER_LOGIN");
		req.setAttribute("login", login);
		switch(action) {
		case UrlConstants.URL_ROLE_LIST:
			List<Role> roles = roleDAO.findAll();
			req.setAttribute("roles", roles);
			req.getRequestDispatcher(PathConstants.PATH_ROLE_LIST).forward(req, resp);
			break;
		case UrlConstants.URL_ROLE_EDIT:
			Role role = roleDAO.findById(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("role", role);
			req.getRequestDispatcher(PathConstants.PATH_ROLE_EDIT).forward(req, resp);
			break;
		case UrlConstants.URL_ROLE_ADD:
			req.getRequestDispatcher(PathConstants.PATH_ROLE_ADD).forward(req, resp);
			break;
		case UrlConstants.URL_ROLE_DELETE:
			System.out.println("DELETE status: " + roleDAO.delete(Integer.parseInt(req.getParameter("id"))));
			resp.sendRedirect(req.getContextPath() + "/role");
			break;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch(action) {
		case UrlConstants.URL_ROLE_EDIT:
			Role change = new Role();
			change.setId(Integer.parseInt(req.getParameter("id")));
			change.setName(req.getParameter("name"));
			change.setDescription(req.getParameter("description"));
			System.out.println("UPDATE status: " + roleDAO.update(change));
			resp.sendRedirect(req.getContextPath() + "/role");
			break;
		case UrlConstants.URL_ROLE_ADD:
			Role add = new Role();
			add.setName(req.getParameter("name"));
			add.setDescription(req.getParameter("description"));
			System.out.println("INSERT status: " + roleDAO.insert(add));
			resp.sendRedirect(req.getContextPath() + "/role");
			break;
		}
	}
}
