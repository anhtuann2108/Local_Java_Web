package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.model.Category;

public interface CategoryService {
	List<Category> categoryList();
	List<Category> searchById(int id);
}
