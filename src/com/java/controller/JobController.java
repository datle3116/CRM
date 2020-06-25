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
import com.java.dao.TaskDAO;
import com.myclass.dto.LoginDTO;
import com.myclass.dto.TaskDTO;
import com.myclass.entity.Job;
import com.myclass.entity.Task;
import com.myclass.util.PathConstants;
import com.myclass.util.UrlConstants;

@WebServlet(urlPatterns = {UrlConstants.URL_JOB_LIST, UrlConstants.URL_JOB_ADD, UrlConstants.URL_JOB_DELETE, UrlConstants.URL_JOB_EDIT, UrlConstants.URL_JOB_DETAIL})
public class JobController extends HttpServlet{
	JobDAO jobDAO = null;
	TaskDAO taskDAO = null;
	@Override
	public void init() throws ServletException {
		jobDAO = new JobDAO();
		taskDAO = new TaskDAO();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		HttpSession session = req.getSession();
		LoginDTO login = (LoginDTO) session.getAttribute("USER_LOGIN");
		req.setAttribute("login", login);
		switch(action) {
		case UrlConstants.URL_JOB_LIST:
			List<Job> jobs = jobDAO.findAll();
			req.setAttribute("jobs", jobs);
			req.getRequestDispatcher(PathConstants.PATH_JOB_LIST).forward(req, resp);
			break;
		case UrlConstants.URL_JOB_ADD:
			req.getRequestDispatcher(PathConstants.PATH_JOB_ADD).forward(req, resp);
			break;
		case UrlConstants.URL_JOB_DELETE:
			int id = Integer.parseInt(req.getParameter("id"));
			List<Task> deleteTasks = taskDAO.findAllTaskByJobId(id);
			for(Task delete : deleteTasks) {
				System.out.println("DELETE task status: " + taskDAO.delete(delete.getId()));
			}
			System.out.println("DELETE job status: " + jobDAO.delete(id));
			resp.sendRedirect(req.getContextPath() + "/job");
			break;
		case UrlConstants.URL_JOB_EDIT:
			Job job = jobDAO.findById(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("job", job);
			req.getRequestDispatcher(PathConstants.PATH_JOB_EDIT).forward(req, resp);
			break;
		case UrlConstants.URL_JOB_DETAIL:
			int jobId = Integer.parseInt(req.getParameter("id"));
			session.setAttribute("jobId", jobId);
			List<TaskDTO> tasks = taskDAO.findAllTaskDTOByJobId(jobId);
			req.setAttribute("tasks", tasks);
			req.setAttribute("jobName", jobDAO.findById(jobId).getName());
			req.getRequestDispatcher(PathConstants.PATH_JOB_DETAIL).forward(req, resp);
			break;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch(action) {
		case UrlConstants.URL_JOB_ADD:
			Job add = new Job();
			String startDateStr = req.getParameter("startDate");
			String endDateStr = req.getParameter("endDate");
			Date startDate = Date.valueOf(startDateStr);
			Date endDate = Date.valueOf(endDateStr);
			
			add.setName(req.getParameter("name"));
			add.setStartDate(startDate);
			add.setEndDate(endDate);
			System.out.println("INSERT status: " + jobDAO.insert(add));
			resp.sendRedirect(req.getContextPath() + "/job");
			
			break;
		case UrlConstants.URL_JOB_EDIT:
			Job change = new Job();
			change.setId(Integer.parseInt(req.getParameter("id")));
			change.setName(req.getParameter("name"));
			change.setStartDate(Date.valueOf(req.getParameter("startDate")));
			change.setEndDate(Date.valueOf(req.getParameter("endDate")));
			System.out.println("UPDATE status: " + jobDAO.update(change));
			resp.sendRedirect(req.getContextPath() + "/job");
			
			break;
		}
	}
}
