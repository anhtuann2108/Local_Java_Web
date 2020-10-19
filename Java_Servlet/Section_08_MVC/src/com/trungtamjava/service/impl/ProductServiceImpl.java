package com.trungtamjava.service.impl;

import java.util.List;

import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.dao.impl.ProductDaoImpl;
import com.trungtamjava.model.Product;
import com.trungtamjava.service.ProductService;

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
		productDao.deleteProduct(id);
		
	}
	@Override
	public List<Product> search(String name) {
		return productDao.search(name);
	}
	@Override
	public List<Product> search(int id) {
		return productDao.search(id);
	}
	@Override
	public Product product(int id) {
		return productDao.product(id);
	}
	@Override
	public void updateProductQuantity(Product product) {
		productDao.updateProductQuantity(product);
		
	}

}
