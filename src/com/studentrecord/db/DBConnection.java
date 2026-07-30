package com.studentrecord.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** 
 * DBConnection class is responsible for creating 
 * and returning a connection to the MySQL database.
 */

public class DBConnection {
	
	// Database URL
	private static final String URL = "jdbc:mysql://localhost:3306/jdbc_demo";
	
	// MySQL Username
	private static final String USER = "your_username";
	
	// MySQL Password
	private static final String PASSWORD = "your_password";
	
	/**
	 * Establishes and returns a database connection.
	 * 
	 * @return Connection object
	 * @throws SQLException if connection fails
	 */
	public static Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			throw new SQLException("Database connection failed. Please check MySQL server.", e);
		}
	}
}
