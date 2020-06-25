package com.java.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.java.dao.JobDAO;
import com.java.dao.TaskDAO;
import com.java.dao.UserDAO;
import com.myclass.dto.LoginDTO;
import com.myclass.dto.TaskDTO;
import com.myclass.dto.UserDTO;
import com.myclass.entity.Job;
import com.myclass.entity.Task;
import com.myclass.entity.User;
import com.myclass.util.PathConstants;
import com.myclass.util.UrlConstants;

@WebServlet(urlPatterns = {UrlConstants.URL_USER_LIST, UrlConstants.URL_USER_DETAIL, UrlConstants.URL_USER_EDIT, UrlConstants.URL_USER_ADD, UrlConstants.URL_USER_DELETE})
public class UserController extends HttpServlet{
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
		case UrlConstants.URL_USER_LIST:
			List<UserDTO> userDTOs = userDAO.findAllUserDTO();
			req.setAttribute("users", userDTOs);
			req.getRequestDispatcher(PathConstants.PATH_USER_LIST).forward(req, resp);
			break;
		case UrlConstants.URL_USER_DETAIL:
			UserDTO userDTO = userDAO.findUserDTOById(Integer.parseInt(req.getParameter("id")));
			List<TaskDTO> tasks = taskDAO.findAllTaskDTOByUserId(userDTO.getId());
			
			req.setAttribute("tasks", tasks);
			req.setAttribute("user", userDTO);
			System.out.println(userDTO.getFullname());
			req.getRequestDispatcher(PathConstants.PATH_USER_DETAIL).forward(req, resp);
			break;
		case UrlConstants.URL_USER_EDIT:
			User user = userDAO.findById(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("user", user);
			req.getRequestDispatcher(PathConstants.PATH_USER_EDIT).forward(req, resp);
			break;
		case UrlConstants.URL_USER_DELETE:
			System.out.println("Delete Status: " + userDAO.delete(Integer.parseInt(req.getParameter("id"))));
			resp.sendRedirect(req.getContextPath() + "/user");
			break;
		case UrlConstants.URL_USER_ADD:
			req.getRequestDispatcher(PathConstants.PATH_USER_ADD).forward(req, resp);
			break;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch(action) {
		case UrlConstants.URL_USER_EDIT:
			User change = new User();
			change.setId(Integer.parseInt(req.getParameter("id")));
			change.setEmail(req.getParameter("email"));
			change.setPassword(BCrypt.hashpw(req.getParameter("password"), BCrypt.gensalt(12)));
			change.setFullname(req.getParameter("fullname"));
			change.setRoleId(Integer.parseInt(req.getParameter("roleId")));
			
			System.out.println("Update status: " + userDAO.update(change));
			resp.sendRedirect(req.getContextPath() + "/user");
			
			break;
		case UrlConstants.URL_USER_ADD:
			User add = new User();
			add.setEmail(req.getParameter("email"));
			add.setPassword(BCrypt.hashpw(req.getParameter("password"), BCrypt.gensalt(12)));
			add.setFullname(req.getParameter("fullname"));
			add.setRoleId(Integer.parseInt(req.getParameter("roleId")));
			
			System.out.println("INSERT status: " + userDAO.add(add));
			resp.sendRedirect(req.getContextPath() + "/user");
			break;
		}
	}
}
