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
	public List<User> findAllUser() {
		List<User> userList = new ArrayList<User>();
		User user = new User();
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "Select * From User";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				user = rowMap(rs);
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public void addUser(User user) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "Insert into User (id,name,username,password,email,phone,favourites,about,role,avatar) values (?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			
			prepareStatement.setInt(1, user.getId());
			prepareStatement.setString(2, user.getName());
			prepareStatement.setString(3, user.getUsername());
			prepareStatement.setString(4, user.getPassword());
			prepareStatement.setString(5, user.getEmail());
			prepareStatement.setString(6, user.getPhone());
			prepareStatement.setString(7, user.getFavourites());
			prepareStatement.setString(8, user.getAbout());
			prepareStatement.setString(9, user.getRole());
			prepareStatement.setString(10, user.getImageAvatar());

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(User user) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "Update User set name = ? , username = ? , password = ?, email = ? , phone = ?, favourites = ? , about = ?, role = ?  where id = ?";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			
			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getUsername());
			prepareStatement.setString(3, user.getPassword());
			prepareStatement.setString(4, user.getEmail());
			prepareStatement.setString(5, user.getPhone());
			prepareStatement.setString(6, user.getFavourites());
			prepareStatement.setString(7, user.getAbout());
			prepareStatement.setString(8, user.getRole());
			prepareStatement.setInt(9, user.getId());

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(int id) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "Delete FROM User where id = ?";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			prepareStatement.setInt(1, id);

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public User findById(int id) {
		User user = new User();
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "Select * From User where id = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, id);

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

	@Override
	public User findbyName(String name) {
		User user = new User();
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "Select * From User where username = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, name);

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
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		user.setPhone(rs.getString("phone"));
		user.setFavourites(rs.getString("favourites"));
		user.setAbout(rs.getString("about"));
		user.setRole(rs.getString("role"));
		user.setImageAvatar(rs.getString("avatar"));
		return user;
	}

	@Override
	public void updateAvatar(User user) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "Update User set avatar = ?  where id = ?";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			
			prepareStatement.setString(1, user.getImageAvatar());
			prepareStatement.setInt(2, user.getId());
		

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateAbout(User user) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "Update User set about = ?  where id = ?";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			
			prepareStatement.setString(1, user.getAbout());
			prepareStatement.setInt(2, user.getId());
		

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
