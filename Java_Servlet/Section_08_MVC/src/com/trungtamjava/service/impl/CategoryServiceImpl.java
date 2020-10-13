package com.trungtamjava.service.impl;

import java.util.List;

import com.trungtamjava.dao.CategoryDao;
import com.trungtamjava.dao.impl.CategoryDaoImpl;
import com.trungtamjava.model.Category;
import com.trungtamjava.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	CategoryDao categoryDao;
	public CategoryServiceImpl() {
		categoryDao = new CategoryDaoImpl();
	}
	
	@Override
	public List<Category> categoryList() {
		return categoryDao.categoryList();
	}

	@Override
	public void add(Category category) {
		categoryDao.add(category);
		
	}

	@Override
	public void update(Category updateCategory) {
		categoryDao.update(updateCategory);
		
	}

	@Override
	public void delete(int id) {
		categoryDao.delete(id);
	}

	@Override
	public Category searchById(int id) {
		return categoryDao.searchById(id);
	}
	
}
