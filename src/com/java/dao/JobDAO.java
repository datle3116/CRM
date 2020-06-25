package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.connection.JDBCConnection;
import com.myclass.entity.Job;
import com.myclass.entity.Role;

public class JobDAO {
	public List<Job> findAll(){
		List<Job> roles = new ArrayList<Job>();
		Job entity = null;
		String query = "SELECT * FROM jobs";
		try(Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statment = conn.prepareStatement(query);
			ResultSet rs = statment.executeQuery();
			while(rs.next()) {
				entity = new Job();
				entity.setId(rs.getInt("id"));
				entity.setName(rs.getString("name"));
				entity.setStartDate(rs.getDate("start_date"));
				entity.setEndDate(rs.getDate("end_date"));
				
				roles.add(entity);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}
	public boolean insert(Job job) {
		String query = "INSERT INTO jobs (name, start_date, end_date) VALUES(?,?,?)";
		try(Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, job.getName());
			statement.setDate(2, job.getStartDate());
			statement.setDate(3, job.getEndDate());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean delete(int id) {
		String query = "DELETE FROM jobs WHERE id = ?";
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
	public Job findById(int id) {
		Job entity = null;
		String query = "SELECT * FROM jobs WHERE id = ?";
		try(Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				entity = new Job();
				entity.setId(rs.getInt("id"));
				entity.setName(rs.getString("name"));
				entity.setStartDate(rs.getDate("start_date"));
				entity.setEndDate(rs.getDate("end_date"));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}
	public boolean update(Job job) {
		String query = "UPDATE jobs SET name = ?, start_date = ?, end_date = ? WHERE id = ?";
		try(Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, job.getName());
			statement.setDate(2, job.getStartDate());
			statement.setDate(3, job.getEndDate());
			statement.setInt(4, job.getId());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
