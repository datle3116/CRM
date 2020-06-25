package com.java.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.java.dao.TaskDAO;
import com.java.dao.UserDAO;
import com.myclass.dto.LoginDTO;
import com.myclass.dto.TaskDTO;
import com.myclass.dto.UserDTO;
import com.myclass.entity.User;
import com.myclass.util.PathConstants;
import com.myclass.util.UrlConstants;

@WebServlet(urlPatterns = {UrlConstants.URL_LOGOUT, UrlConstants.URL_LOGIN_DETAIL, UrlConstants.URL_LOGIN, UrlConstants.URL_LOGIN_EDIT})
public class LoginController extends HttpServlet{
	UserDAO userDAO = null;
	TaskDAO taskDAO = null;
	
	@Override
	public void init() throws ServletException {
		userDAO = new UserDAO();
		taskDAO = new TaskDAO();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		HttpSession session = req.getSession();
		LoginDTO login = (LoginDTO) session.getAttribute("USER_LOGIN");
		req.setAttribute("login", login);
		switch(action) {
		case UrlConstants.URL_LOGOUT:
			if(session != null || session.getAttribute("USER_LOGIN") != null) {
				session.removeAttribute("USER_LOGIN");
			}
			req.getRequestDispatcher(PathConstants.PATH_LOGIN).forward(req, resp);
			break;
		case UrlConstants.URL_LOGIN_DETAIL:
			UserDTO userDTO = userDAO.findUserDTOById(Integer.parseInt(req.getParameter("id")));
			List<TaskDTO> tasks = taskDAO.findAllTaskDTOByUserId(userDTO.getId());
			req.setAttribute("tasks", tasks);
			req.setAttribute("user", userDTO);
			req.getRequestDispatcher(PathConstants.PATH_LOGIN_DETAIL).forward(req, resp);
			break;
		case UrlConstants.URL_LOGIN:
			req.getRequestDispatcher(PathConstants.PATH_LOGIN).forward(req, resp);
			break;
		case UrlConstants.URL_LOGIN_EDIT:
			User user = userDAO.findById(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("user", user);
			req.getRequestDispatcher(PathConstants.PATH_LOGIN_EDIT).forward(req, resp);
			break;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch(action) {
		case UrlConstants.URL_LOGIN:
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			LoginDTO login = userDAO.findLogin(email);
			if(login == null || BCrypt.checkpw(password, login.getPassword()) == false) {
				req.setAttribute("message", "Đăng nhập thất bại!");
				req.getRequestDispatcher(PathConstants.PATH_LOGIN).forward(req, resp);
				return;
			}
			
			HttpSession session = req.getSession();
			session.setAttribute("USER_LOGIN", login);
			
			resp.sendRedirect(req.getContextPath() + "/home");
			break;
		case UrlConstants.URL_LOGIN_EDIT:
			User change = new User();
			change.setId(Integer.parseInt(req.getParameter("id")));
			change.setEmail(req.getParameter("email"));
			change.setPassword(BCrypt.hashpw(req.getParameter("password"), BCrypt.gensalt(12)));
			change.setFullname(req.getParameter("fullname"));
			change.setRoleId(Integer.parseInt(req.getParameter("roleId")));
			
			System.out.println("Update status: " + userDAO.update(change));
			resp.sendRedirect(req.getContextPath() + "/home");
			break;
		}
		
	}
}
