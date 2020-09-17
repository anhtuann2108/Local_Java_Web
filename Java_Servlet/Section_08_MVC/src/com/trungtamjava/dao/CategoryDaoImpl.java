package com.trungtamjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<Category> searchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	private Category rowMap(ResultSet rs) throws SQLException {
		Category category = new Category();
		category.setId(rs.getInt("id"));
		category.setNameCate(rs.getString("name"));
		
		return category;
	}
}
