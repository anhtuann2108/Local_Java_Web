package com.trungtamjava.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.dao.CategoryDao;
import com.trungtamjava.dao.JDBCConnection;
import com.trungtamjava.model.Category;

public class CategoryDaoImpl implements CategoryDao{

	@Override
	public List<Category> categoryList() {
		List<Category> categoryList = new ArrayList<Category>();
		Category category = new Category();
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "Select * From Category";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				category = rowMap(rs);
				categoryList.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryList;
	}
	
	private Category rowMap(ResultSet rs) throws SQLException {
		Category category = new Category();
		category.setId(rs.getInt("id"));
		category.setNameCate(rs.getString("name"));
		
		return category;
	}

	@Override
	public void add(Category category) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "Insert into Category (id,name) values (?,?)";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			
			prepareStatement.setInt(1, category.getId());
			prepareStatement.setString(2, category.getNameCate());
			
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		Connection connection = JDBCConnection.getJDBCConnection();
		
		String sql = "Delete FROM Category where id = ?";
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
	public void update(Category updateCategory) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "Update Category set name = ? where id = ?";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			prepareStatement.setString(1, updateCategory.getNameCate());
			prepareStatement.setInt(2, updateCategory.getId());
			
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Category searchById(int id) {
		Connection connection = JDBCConnection.getJDBCConnection();
		
		Category category = new Category();
		
		String sql = "Select * From Category where id = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			prepareStatement.setInt(1, id);
			
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				category = rowMap(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return category;
	}
	
}
