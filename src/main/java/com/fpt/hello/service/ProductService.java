package com.fpt.hello.service;

import java.util.List;

import com.fpt.hello.model.Product;

public interface ProductService {

	void update(Product product);

	List<Product> getAll();

	void remove(int productId);

	void add(Product product);

	Product findById(int productId);

}
