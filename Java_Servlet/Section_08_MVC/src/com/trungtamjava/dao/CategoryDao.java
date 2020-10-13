package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.Category;

public interface CategoryDao {
	void add(Category category);

	void delete(int id);

	void update(Category updateCategory);
	
	List<Category> categoryList();
	
	Category searchById(int id);
}
