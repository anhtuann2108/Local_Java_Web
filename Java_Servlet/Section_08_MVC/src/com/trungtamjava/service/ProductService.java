package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.model.Product;

public interface ProductService {
	List<Product> listProduct();
	void addProduct(Product product);
	List<Product> search(String name);
	List<Product> search(int id);
	void updateProduct(Product product);
	void deleteProduct(int id);
}
