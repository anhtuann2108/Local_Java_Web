package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.model.Bill;

public interface BillService {
	void create(Bill b);

	void update(Bill b);

	void delete(int id);

	Bill get(int id);

	List<Bill> search(int userId);
	
	List<Bill> getAll();
}
