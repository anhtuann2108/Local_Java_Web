package com.trungtamjava.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.dao.JDBCConnection;
import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.model.Product;



public class ProductDaoImpl implements ProductDao{

	@Override
	public List<Product> listProduct() {
		List<Product> productList = new ArrayList<Product>();
		Product product = new Product();
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "Select * From Product";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				product = rowMap(rs);
				productList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public void addProduct(Product product) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "Insert into Product (id,productname,description,price,image,category,quantity) values (?,?,?,?,?,?,?)";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			
			prepareStatement.setInt(1, product.getId());
			prepareStatement.setString(2, product.getProductname());
			prepareStatement.setString(3, product.getDescription());
			prepareStatement.setDouble(4, product.getPrice());
			prepareStatement.setString(5, product.getImage());
			prepareStatement.setInt(6, product.getCategory().getId());
			prepareStatement.setInt(7, product.getQuantity());
			
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateProduct(Product product) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "Update Product set productname = ? , description = ? , price = ?, image = ? , category = ?  where id = ?";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			prepareStatement.setString(1, product.getProductname());
			prepareStatement.setString(2, product.getDescription());
			prepareStatement.setInt(3, product.getPrice());
			prepareStatement.setString(4, product.getImage());
			prepareStatement.setInt(5, product.getCategory().getId());
			prepareStatement.setInt(6, product.getId());
			

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProduct(int id) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "Delete FROM Product where id = ?";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			prepareStatement.setInt(1, id);

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private Product rowMap(ResultSet rs) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt("id"));
		product.setProductname(rs.getString("productname"));
		product.setDescription(rs.getString("description"));
		product.setPrice(Integer.parseInt(rs.getString("price")));
		product.setImage(rs.getString("image"));
		product.setQuantity(rs.getInt("quantity"));
		
		return product;
	}

	@Override
	public List<Product> search(int id) {
		List<Product> productList = new ArrayList<Product>();
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "Select product.ProductName,product.Price,product.Description,product.Image,product.Id,product.quantity"
				+ " from product inner join category"
				+ " on product.Category = category.ID where Category.id = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1,id);

			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				Product product = rowMap(rs);
				productList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
		
	}

	@Override
	public List<Product> search(String name) {
		List<Product> productList = new ArrayList<Product>();
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "Select * From Product where productname like ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, "%"+name+"%");

			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				Product product = rowMap(rs);
				productList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
		
	}

	@Override
	public Product product(int id) {
		Product product = null;
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "Select * From Product where id = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, id);

			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				product = rowMap(rs);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public void updateProductQuantity(Product product) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "Update Product set quantity = ?  where id = ?";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			prepareStatement.setInt(1, product.getQuantity());
			prepareStatement.setInt(2, product.getId());

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
