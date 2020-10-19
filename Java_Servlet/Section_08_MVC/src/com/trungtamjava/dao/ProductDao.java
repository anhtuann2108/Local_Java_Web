package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.Product;

public interface ProductDao {
	List<Product> listProduct();
	void addProduct(Product product);
	List<Product> search(int id);
	List<Product> search(String name);
	Product product(int id);
	void updateProduct(Product product);
	void updateProductQuantity(Product product);
	void deleteProduct(int id);
}
