package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.model.Category;

public interface CategoryService {
	void add(Category category);
	void update(Category updateCategory);
	void delete(int id);
	List<Category> categoryList();
	Category searchById(int id);
}
