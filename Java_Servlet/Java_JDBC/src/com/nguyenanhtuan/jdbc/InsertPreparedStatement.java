package com.nguyenanhtuan.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertPreparedStatement {
	public static void insertPrepared(int id,String name,int age) {
		Connection conn =JDBC_Connection.getJDBCConnection();
		String sql = "Insert Into student(ID,Name,Age) values(?,?,?)";
		try {
			PreparedStatement prepared = conn.prepareStatement(sql);
			prepared.setInt(1, id);
			prepared.setString(2, name);
			prepared.setInt(3, age);
			
			int rs = prepared.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void updateRecords(int id,String newName) {
		Connection conn =JDBC_Connection.getJDBCConnection();
		String sql = "Update student set name = ? where id = ?";
		try {
			PreparedStatement prepared = conn.prepareStatement(sql);
			prepared.setString(1, newName);
			prepared.setInt(2, id);
			
			
			int rs = prepared.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void deleteRecords(int id) {
		Connection conn =JDBC_Connection.getJDBCConnection();
		String sql = "Delete from student where id= ?";
		try {
			PreparedStatement prepared = conn.prepareStatement(sql);
			prepared.setInt(1, id);
		
			int rs = prepared.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		insertPrepared(6, "You are very awsome", 27);
		deleteRecords(2);
	}

}
