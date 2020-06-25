package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.connection.JDBCConnection;
import com.myclass.dto.LoginDTO;
import com.myclass.dto.UserDTO;
import com.myclass.entity.User;

public class UserDAO {
	public List<User> findAll(){//tim kiem danh sach cac User
		String query = "SELECT * FROM users";
		List<User> users = new ArrayList<User>();
		try(Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				User entity = new User();
				entity.setId(rs.getInt("id"));
				entity.setEmail(rs.getString("email"));
				entity.setPassword(rs.getString("password"));
				entity.setFullname(rs.getString("fullname"));
				entity.setAvatar(rs.getString("avatar"));
				entity.setRoleId(rs.getInt("role_id"));
				
				users.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public List<UserDTO> findAllUserDTO(){
		String query = "SELECT u.id, u.email, u.fullname, u.password, r.description as description FROM users u JOIN roles r ON u.role_id = r.id";
		List<UserDTO> users = new ArrayList<UserDTO>();
		try(Connection conn = JDBCConnection.getConnection()) {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				UserDTO entity = new UserDTO();
				entity.setId(rs.getInt("id"));
				entity.setEmail(rs.getString("email"));
				entity.setFullname(rs.getString("fullname"));
				entity.setDescription(rs.getString("description"));
				entity.setPassword(rs.getString("password"));
				
				users.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public LoginDTO findLogin(String email) {
		String query = "SELECT u.id as id, u.email, u.password, u.fullname, r.name as roleName FROM users u "
				+ "JOIN roles r " + "ON u.role_id = r.id " + "WHERE u.email = ?";
		LoginDTO entity = null;
		try(Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				entity = new LoginDTO();
				entity.setId(rs.getInt("id"));
				entity.setEmail(rs.getString("email"));
				entity.setPassword(rs.getString("password"));
				entity.setFullname(rs.getString("fullname"));
				entity.setRoleName(rs.getString("roleName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}
	public UserDTO findUserDTOById(int id) {//tim kiem UserDTO theo Id
		String query = "SELECT u.id, u.email, u.fullname, u.password, r.description as description, r.name as role_name FROM users u JOIN roles r ON r.id = u.role_id WHERE u.id = ?";
		UserDTO entity = new UserDTO();
		try(Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				entity.setId(rs.getInt("id"));
				entity.setEmail(rs.getString("email"));
				entity.setPassword(rs.getString("password"));
				entity.setFullname(rs.getString("fullname"));
				entity.setDescription(rs.getString("description"));
				entity.setRoleName(rs.getString("role_name"));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}
	
	public User findById(int id) {//tim kiem User theo Id
		String query = "SELECT * FROM users WHERE id = ?";
		User entity = new User();
		try(Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				entity.setId(rs.getInt("id"));
				entity.setEmail(rs.getString("email"));
				entity.setPassword(rs.getString("password"));
				entity.setFullname(rs.getString("fullname"));
				entity.setAvatar(rs.getString("avatar"));
				entity.setRoleId(rs.getInt("role_id"));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}
	
	public boolean update(User user) {
		String query = "UPDATE users u SET u.email = ?, u.password = ?, u.fullname = ?, u.avatar = ?, u.role_id = ? WHERE u.id = ?";
		try(Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFullname());
			statement.setString(4, user.getAvatar());
			statement.setInt(5, user.getRoleId());
			statement.setInt(6, user.getId());
			
			statement.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(int id) {
		String query = "DELETE FROM users WHERE id = ?";
		try(Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean add(User user) {
		String query = "INSERT INTO users (email, password, fullname, role_id) VALUES (?, ?, ?, ?)";
		try(Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFullname());
			statement.setInt(4, user.getRoleId());
			statement.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
