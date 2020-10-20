package com.trungtamjava.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.dao.BillDao;
import com.trungtamjava.dao.JDBCConnection;
import com.trungtamjava.model.Bill;
import com.trungtamjava.model.Product;
import com.trungtamjava.model.User;

public class BillDaoImpl implements BillDao{

	@Override
	public void create(Bill b) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "Insert into Bill (id,buyer_id,buy_date,price_total,quantity,price,product) values (?,?,?,?,?,?,?)";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			
			prepareStatement.setInt(1, b.getId());
			prepareStatement.setInt(2, b.getBuyer().getId());
			prepareStatement.setString(3, b.getBuyDate());
			prepareStatement.setLong(4, b.getPriceTotal());
			prepareStatement.setInt(5, b.getQuantity());
			prepareStatement.setInt(6,b.getPrice());
			prepareStatement.setString(7,b.getProduct().getProductname());
			
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Bill b) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "Update Bill set buy_date = ? ,buyer_id = ? ,product = ? ,quantity = ?, price_total = ?  where id = ?";

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			
			prepareStatement.setString(1, b.getBuyDate());
			prepareStatement.setInt(2, b.getBuyer().getId());
			prepareStatement.setString(3, b.getProduct().getProductname());
			prepareStatement.setInt(4, b.getQuantity());
			prepareStatement.setInt(5, b.getPrice()*b.getQuantity());
			prepareStatement.setInt(6, b.getId());

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		Connection connection = JDBCConnection.getJDBCConnection();

		String sql = "Delete FROM Bill where id = ?";

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
	public Bill get(int id) {
		Bill bill = null;
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "Select * From Bill where id = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1,id);

			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				bill = rowMap(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bill;
	}

	@Override
	public List<Bill> search(int userId) {
		List<Bill> billList = new ArrayList<Bill>();
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "Select * From Bill where buyer_id = ?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1,userId);

			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				Bill bill = rowMap(rs);
				billList.add(bill);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return billList;
	}

	@Override
	public List<Bill> getAll() {
		List<Bill> billList = new ArrayList<Bill>();
		Connection connection = JDBCConnection.getJDBCConnection();
		String sql = "Select * From Bill";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				Bill bill = rowMap(rs);
				billList.add(bill);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return billList;
	}
	private Bill rowMap(ResultSet rs) throws SQLException {
		Bill bill = new Bill();
		User user = new User();
		Product product = new Product();
		bill.setId(rs.getInt("id"));
		bill.setBuyDate(rs.getString("buy_date"));
		user.setId(rs.getInt("buyer_id"));
		bill.setBuyer(user);
		bill.setPrice(rs.getInt("price"));
		bill.setPriceTotal(rs.getInt("price_total"));
		bill.setQuantity(rs.getInt("quantity"));
		product.setProductname(rs.getString("product"));
		bill.setProduct(product);
		return bill;
	}

}
