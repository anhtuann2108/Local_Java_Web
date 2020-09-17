package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.dao.CategoryDao;
import com.trungtamjava.dao.CategoryDaoImpl;
import com.trungtamjava.model.Category;

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
	public List<Category> searchById(int id) {
		return categoryDao.searchById(id);
	}
	
}
