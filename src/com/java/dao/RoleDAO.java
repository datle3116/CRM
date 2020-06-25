package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.connection.JDBCConnection;
import com.myclass.entity.Role;

public class RoleDAO {
	public List<Role> findAll(){
		List<Role> roles = new ArrayList<Role>();
		Role entity = null;
		String query = "SELECT * FROM roles";
		try(Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statment = conn.prepareStatement(query);
			ResultSet rs = statment.executeQuery();
			while(rs.next()) {
				entity = new Role();
				entity.setId(rs.getInt("id"));
				entity.setName(rs.getString("name"));
				entity.setDescription(rs.getString("description"));
				
				roles.add(entity);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}
	public Role findById(int id) {
		Role entity = null;
		String query = "SELECT * FROM roles WHERE id = ?";
		try(Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				entity = new Role();
				entity.setId(rs.getInt("id"));
				entity.setName(rs.getString("name"));
				entity.setDescription(rs.getString("description"));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}
	public boolean update(Role role) {
		String query = "UPDATE roles r SET r.name = ?, r.description = ? WHERE id = ?";
		try(Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(3, role.getId());
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean insert(Role role) {
		String query = "INSERT INTO roles (name, description) VALUES(?,?)";
		try(Connection conn = JDBCConnection.getConnection()){
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(int id) {
		String query = "DELETE FROM roles WHERE id = ?";
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
}
