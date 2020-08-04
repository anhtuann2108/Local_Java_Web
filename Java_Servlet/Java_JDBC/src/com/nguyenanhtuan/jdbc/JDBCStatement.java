package com.nguyenanhtuan.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStatement {

	public static void main(String[] args) {
		try {
			Connection con = JDBC_Connection.getJDBCConnection();
			Statement statement =con.createStatement();
			
			String sql = "SELECT * FROM student";
			
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getNString("Name");
				int age = rs.getInt("Age");
				
				System.out.println(id+" "+ name +" "+age);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
