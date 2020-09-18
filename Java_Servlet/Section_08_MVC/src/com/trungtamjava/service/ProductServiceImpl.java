package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.dao.ProductDaoImpl;
import com.trungtamjava.model.Product;

public class ProductServiceImpl implements ProductService{
	private ProductDao  productDao;
	public ProductServiceImpl() {
		productDao = new ProductDaoImpl();
	}
	@Override
	public List<Product> listProduct() {
		return productDao.listProduct();
	}

	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
		
	}

	@Override
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Product> search(String name) {
		return productDao.search(name);
	}
	@Override
	public List<Product> search(int id) {
		return productDao.search(id);
	}

}
