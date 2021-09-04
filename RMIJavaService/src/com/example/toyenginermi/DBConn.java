package com.example.toyenginermi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	public static Connection getConnection(){
		Connection connection = null;
		
		try{
			connection = DriverManager.getConnection(Constants._CONNECTION_URL);
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		return connection;
	}
}
