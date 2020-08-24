package com.trungtamjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.model.User;

public class UserDaoImpl implements UserDao{

	@Override
	public void createUser(User user) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "Insert into User (username,password,email) values (?,?,?)";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			prepareStatement.setString(1, user.getUsername());
			prepareStatement.setString(2, user.getPassword());
			prepareStatement.setString(3, user.getEmail());

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public User search(String username) {
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
		user.setEmail(rs.getString("email"));
		return user;
	}

}
