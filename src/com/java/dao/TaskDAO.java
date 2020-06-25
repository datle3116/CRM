package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.connection.JDBCConnection;
import com.myclass.dto.TaskDTO;
import com.myclass.entity.Task;

public class TaskDAO {
	public List<Task> findAll(){
		List<Task> tasks = null;
		String query = "SELECT * FROM tasks";
		try(Connection conn = JDBCConnection.getConnection()){
			tasks = new ArrayList<Task>();
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setStartDate(rs.getDate("start_date"));
				task.setEndDate(rs.getDate("end_date"));
				task.setStatusId(rs.getInt("status_id"));
				task.setJobId(rs.getInt("job_id"));
				task.setUserId(rs.getInt("user_id"));
				
				tasks.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}
	public List<TaskDTO> findAllTaskDTO(){
		List<TaskDTO> tasks = null;
		String query = "SELECT t.id, t.name, t.start_date, t.end_date, t.job_id, u.fullname as user_name, u.id as user_id, j.name as job_name, s.name as status_name FROM tasks t "
				+ "JOIN users u ON u.id = t.user_id "
				+ "JOIN jobs j ON j.id = t.job_id "
				+ "JOIN status s ON s.id = t.status_id";
		try(Connection conn = JDBCConnection.getConnection()){
			tasks = new ArrayList<TaskDTO>();
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				TaskDTO task = new TaskDTO();
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setStartDate(rs.getDate("start_date"));
				task.setEndDate(rs.getDate("end_date"));
				task.setJobName(rs.getString("job_name"));
				task.setStatusName(rs.getString("status_name"));
				task.setUserName(rs.getString("user_name"));
				task.setJobId(rs.getInt("job_id"));
				
				tasks.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}
	public List<TaskDTO> findAllTaskDTOByJobId(int id){
		List<TaskDTO> tasks = new ArrayList<TaskDTO>();
		String query = "SELECT t.id, t.name, t.start_date, t.end_date, t.job_id, u.fullname as user_name, u.id as user_id, j.name as job_name, s.name as status_name, t.status_id FROM tasks t "
				+ "JOIN users u ON u.id = t.user_id "
				+ "JOIN jobs j ON j.id = t.job_id "
				+ "JOIN status s ON s.id = t.status_id "
				+ "WHERE j.id = ?";
		try(Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				TaskDTO task = new TaskDTO();
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setStartDate(rs.getDate("start_date"));
				task.setEndDate(rs.getDate("end_date"));
				task.setJobName(rs.getString("job_name"));
				task.setStatusName(rs.getString("status_name"));
				task.setUserName(rs.getString("user_name"));
				task.setUserId(rs.getInt("user_id"));
				task.setJobId(rs.getInt("job_id"));
				task.setStatusId(rs.getInt("status_id"));
				tasks.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}
	public boolean insert(Task task) {
		String query = "INSERT INTO tasks (name, start_date, end_date, user_id, job_id, status_id) VALUES (?,?,?,?,?,?)";
		try(Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, task.getName());
			statement.setDate(2, task.getStartDate());
			statement.setDate(3, task.getEndDate());
			statement.setInt(4, task.getUserId());
			statement.setInt(5, task.getJobId());
			statement.setInt(6, task.getStatusId());
			
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean delete(int id) {
		String query = "DELETE FROM tasks WHERE id = ?";
		try(Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public List<Task> findAllTaskByJobId(int id) {
		List<Task> tasks = null;
		String query = "SELECT * FROM tasks WHERE job_id = ?";
		try(Connection conn = JDBCConnection.getConnection()){
			tasks = new ArrayList<Task>();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setStartDate(rs.getDate("start_date"));
				task.setEndDate(rs.getDate("end_date"));
				task.setUserId(rs.getInt("user_id"));
				task.setJobId(rs.getInt("job_id"));
				task.setStatusId(rs.getInt("status_id"));
				tasks.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}
	public Task findById(int id) {
		Task task = null;
		String query = "SELECT * FROM tasks WHERE id = ?";
		try(Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				task = new Task();
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setStartDate(rs.getDate("start_date"));
				task.setEndDate(rs.getDate("end_date"));
				task.setUserId(rs.getInt("user_id"));
				task.setJobId(rs.getInt("job_id"));
				task.setStatusId(rs.getInt("status_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return task;
	}
	public boolean update(Task task) {
		String query = "UPDATE tasks SET name = ?, start_date = ?, end_date = ?, user_id = ?, job_id = ?, status_id = ? WHERE id = ?";
		try(Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, task.getName());
			statement.setDate(2, task.getStartDate());
			statement.setDate(3, task.getEndDate());
			statement.setInt(4, task.getUserId());
			statement.setInt(5, task.getJobId());
			statement.setInt(6, task.getStatusId());
			statement.setInt(7, task.getId());
			
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public List<TaskDTO> findAllTaskDTOByUserId(int id){
		List<TaskDTO> tasks = new ArrayList<TaskDTO>();
		String query = "SELECT t.id, t.name, t.start_date, t.end_date, t.job_id, u.fullname as user_name, u.id as user_id, j.name as job_name, s.name as status_name, t.status_id FROM tasks t "
				+ "JOIN users u ON u.id = t.user_id "
				+ "JOIN jobs j ON j.id = t.job_id "
				+ "JOIN status s ON s.id = t.status_id "
				+ "WHERE u.id = ?";
		try(Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				TaskDTO task = new TaskDTO();
				task.setId(rs.getInt("id"));
				task.setName(rs.getString("name"));
				task.setStartDate(rs.getDate("start_date"));
				task.setEndDate(rs.getDate("end_date"));
				task.setJobName(rs.getString("job_name"));
				task.setStatusName(rs.getString("status_name"));
				task.setUserName(rs.getString("user_name"));
				task.setUserId(rs.getInt("user_id"));
				task.setJobId(rs.getInt("job_id"));
				task.setStatusId(rs.getInt("status_id"));
				tasks.add(task);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}
}
