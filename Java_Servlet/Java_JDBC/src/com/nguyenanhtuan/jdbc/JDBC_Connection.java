package com.nguyenanhtuan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connection {
	public static Connection getJDBCConnection() {
		final String url = "jdbc:mysql://localhost:3306/javaweb?useSSL=false";
		final String user = "root";
		final String password = "171293";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url,user,password);
		}
		 catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public static void main(String[] args) {
		Connection connection = getJDBCConnection();
		
		if(connection != null) {
			System.out.println("Success");
		}else {
			System.out.println("Not success");
		}
	}
}
