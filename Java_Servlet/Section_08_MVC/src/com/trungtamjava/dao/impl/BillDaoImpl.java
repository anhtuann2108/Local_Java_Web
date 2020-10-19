package com.trungtamjava.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.trungtamjava.dao.BillDao;
import com.trungtamjava.dao.JDBCConnection;
import com.trungtamjava.model.Bill;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bill get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> search(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
