package com.nguyenanhtuan.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class SelectPrepareStatement {
	public static void main(String[] args) {
		Connection conn = JDBC_Connection.getJDBCConnection();
		
		String sql= "Select * From student where id= ? and name = ?";
		
		try {
			PreparedStatement prepared = conn.prepareStatement(sql);
			
			prepared.setInt(1, 1);
			prepared.setString(2, "Dinh Thi Huong");
			ResultSet rs = prepared.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("ID")+ " "+ rs.getNString("Name")+" " + rs.getInt("Age"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
