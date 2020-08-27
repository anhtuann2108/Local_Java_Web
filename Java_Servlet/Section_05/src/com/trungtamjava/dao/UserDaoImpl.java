package com.trungtamjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trungtamjava.model.User;

public class UserDaoImpl implements UserDao{

	@Override
	public void create(User user) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "Insert into User (username,password,role) values (?,?,?)";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			
			prepareStatement.setString(1, user.getUsername());
			prepareStatement.setString(2, user.getPassword());
			prepareStatement.setString(3, user.getRole());

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public User find(String username) {
		User user = new User();
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "Select * From User where username = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, username);

			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				user = rowMap(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	private User rowMap(ResultSet rs) throws SQLException {
		User user = new User();
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setRole(rs.getString("role"));
		return user;
	}
	
}
