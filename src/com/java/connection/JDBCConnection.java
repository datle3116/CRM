package com.java.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Mục đích: lớp kết nối Database bằng JDBC
 * Người tạo: Lê Tiến Đạt
 * Ngày tạo: 18/02/2020
 * */
public class JDBCConnection {
	public static Connection getConnection() {
		final String database = "jdbc:mysql://127.0.0.1:3306/crm";
		final String username = "root";
		final String password = "123456";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(database, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
