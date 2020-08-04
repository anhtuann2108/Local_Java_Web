package com.nguyenanhtuan.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectStatement {

	public static void main(String[] args) {
		Connection conn = JDBC_Connection.getJDBCConnection();
		
		try {
			final String sql="Select * from student where ID=1";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("Name");
				int age = rs.getInt("Age");
				System.out.println(id+" "+ name +" "+age);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
