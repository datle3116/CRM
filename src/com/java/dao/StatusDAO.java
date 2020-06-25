package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.connection.JDBCConnection;
import com.myclass.entity.Status;

public class StatusDAO {
	public List<Status> findAll(){
		 String query = "SELECT * FROM status";
		 List<Status> status = null;
		 try(Connection conn = JDBCConnection.getConnection()){
			 status = new ArrayList<Status>();
			 PreparedStatement statement = conn.prepareStatement(query);
			 ResultSet rs = statement.executeQuery();
			 while(rs.next()) {
				 Status entity = new Status();
				 entity.setId(rs.getInt("id"));
				 entity.setName(rs.getString("name"));
				 status.add(entity);
			 }
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		 return status;
	}
}
