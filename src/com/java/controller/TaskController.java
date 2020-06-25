package com.java.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.dao.JobDAO;
import com.java.dao.StatusDAO;
import com.java.dao.TaskDAO;
import com.java.dao.UserDAO;
import com.myclass.dto.LoginDTO;
import com.myclass.dto.TaskDTO;
import com.myclass.entity.Job;
import com.myclass.entity.Status;
import com.myclass.entity.Task;
import com.myclass.entity.User;
import com.myclass.util.PathConstants;
import com.myclass.util.UrlConstants;

@WebServlet(urlPatterns = {UrlConstants.URL_TASK_ADD, UrlConstants.URL_TASK_DELETE, UrlConstants.URL_TASK_EDIT, UrlConstants.URL_TASK_LIST})
public class TaskController extends HttpServlet{
	TaskDAO taskDAO = null;
	JobDAO jobDAO = null;
	UserDAO userDAO = null;
	StatusDAO statusDAO = null;
	@Override
	public void init() throws ServletException {
		taskDAO = new TaskDAO();
		jobDAO = new JobDAO();
		userDAO = new UserDAO();
		statusDAO = new StatusDAO();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		HttpSession session = req.getSession();
		LoginDTO login = (LoginDTO) session.getAttribute("USER_LOGIN");
		req.setAttribute("login", login);
		switch(action) {
		case UrlConstants.URL_TASK_LIST:
			List<TaskDTO> tasks = taskDAO.findAllTaskDTO();
			req.setAttribute("tasks", tasks);
			req.getRequestDispatcher(PathConstants.PATH_TASK_LIST).forward(req, resp);
			break;
		case UrlConstants.URL_TASK_ADD:
			List<Job> jobs = jobDAO.findAll();
			List<User> users = userDAO.findAll();
			List<Status> listStatus = statusDAO.findAll();
			int jobId = (int) session.getAttribute("jobId");
			session.removeAttribute("jobId");
			
			req.setAttribute("jobId", jobId);
			req.setAttribute("jobs", jobs);
			req.setAttribute("users", users);
			req.setAttribute("listStatus", listStatus);
			req.getRequestDispatcher(PathConstants.PATH_TASK_ADD).forward(req, resp);
			break;
		case UrlConstants.URL_TASK_DELETE:
			jobId = (int) session.getAttribute("jobId");
			session.removeAttribute("jobId");
			System.out.println("DELETE Status: " + taskDAO.delete(Integer.parseInt(req.getParameter("id"))));
			resp.sendRedirect(req.getContextPath() + "/job/detail?id=" + jobId);
			break;
		case UrlConstants.URL_TASK_EDIT:
			jobs = jobDAO.findAll();
			users = userDAO.findAll();
			listStatus = statusDAO.findAll();
			Task task = taskDAO.findById(Integer.parseInt(req.getParameter("id")));
			
			req.setAttribute("task", task);
			req.setAttribute("jobs", jobs);
			req.setAttribute("users", users);
			req.setAttribute("listStatus", listStatus);
			req.getRequestDispatcher(PathConstants.PATH_TASK_EDIT).forward(req, resp);
			break;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch(action) {
		case UrlConstants.URL_TASK_ADD:
			Task add = new Task();
			add.setName(req.getParameter("name"));
			add.setStartDate(Date.valueOf(req.getParameter("startDate")));
			add.setEndDate(Date.valueOf(req.getParameter("endDate")));
			add.setUserId(Integer.parseInt(req.getParameter("userId")));
			add.setJobId(Integer.parseInt(req.getParameter("jobId")));
			add.setStatusId(Integer.parseInt(req.getParameter("statusId")));
			
			System.out.println("INSERT STATUS: " + taskDAO.insert(add));
			resp.sendRedirect(req.getContextPath() + "/job/detail?id=" + add.getJobId());
			break;
		case UrlConstants.URL_TASK_EDIT:
			HttpSession session = req.getSession();
			int jobId = (int) session.getAttribute("jobId");
			session.removeAttribute("jobId");
			Task change = new Task();
			change.setId(Integer.parseInt(req.getParameter("id")));
			change.setName(req.getParameter("name"));
			change.setStartDate(Date.valueOf(req.getParameter("startDate")));
			change.setEndDate(Date.valueOf(req.getParameter("endDate")));
			change.setUserId(Integer.parseInt(req.getParameter("userId")));
			change.setJobId(Integer.parseInt(req.getParameter("jobId")));
			change.setStatusId(Integer.parseInt(req.getParameter("statusId")));
			
			System.out.println("UPDATE status: " + taskDAO.update(change));
			resp.sendRedirect(req.getContextPath() + "/job/detail?id=" + jobId);
			break;
		}
	}
}
