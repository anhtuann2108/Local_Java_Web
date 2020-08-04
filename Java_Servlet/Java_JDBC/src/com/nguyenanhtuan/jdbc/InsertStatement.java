package com.nguyenanhtuan.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStatement {
	public static void insertRecords(int id , String name,int age) {
		Connection conn = JDBC_Connection.getJDBCConnection();
		try {
			Statement statement = conn.createStatement();
			String sql = "Insert into student(ID,Name,Age) values("+id+",'"+name+"',"+age+")";
			int rs =statement.executeUpdate(sql);
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void updateRecords(int id , String newName) {
		Connection conn = JDBC_Connection.getJDBCConnection();
		try {
			Statement statement = conn.createStatement();
			String sql = "Update student set name='"+newName+"' where id="+id;
			int rs =statement.executeUpdate(sql);
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void deleteRecords(int id) {
		Connection conn = JDBC_Connection.getJDBCConnection();
		try {
			Statement statement = conn.createStatement();
			String sql = "Delete from student where id="+id;
			int rs =statement.executeUpdate(sql);
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		insertRecords(1, "Dinh Thi Huong", 25);
	}

}
