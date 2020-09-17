package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.Category;

public interface CategoryDao {
	List<Category> categoryList();
	List<Category> searchById(int id);
}
