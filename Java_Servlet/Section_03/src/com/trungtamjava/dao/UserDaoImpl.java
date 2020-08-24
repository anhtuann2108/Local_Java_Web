package com.trungtamjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void insert(User user) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "Insert into User (id,name,age) values (?,?,?)";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			prepareStatement.setInt(1, user.getId());
			prepareStatement.setString(2, user.getName());
			prepareStatement.setInt(3, user.getAge());

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(User user) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "Update User set name = ? , age = ? where id = ?";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			prepareStatement.setString(1, user.getName());
			prepareStatement.setInt(2, user.getAge());
			prepareStatement.setInt(3, user.getId());

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(User user) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "Delete FROM User where id = ?";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			prepareStatement.setInt(1, user.getId());

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<User> search(int id) {
		List<User> users = new ArrayList<User>();
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "Select * From User where id = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, id);

			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				User user = rowMap(rs);
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	private User rowMap(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setAge(rs.getInt("age"));
		return user;
	}
	@Override
	public void infor(User user) {
		System.out.println("ID: "+user.getId()+" Name: "+user.getName()+" Age: "+user.getAge());
	}

	@Override
	public List<User> UserList() {
		List<User> users = new ArrayList<User>();
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "Select * From User";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				User user = rowMap(rs);
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

}