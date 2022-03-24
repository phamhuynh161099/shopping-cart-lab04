package com.fpt.hello.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fpt.hello.model.Product;
import com.fpt.hello.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private static List<Product> list=new ArrayList<>();
	static {
		list.add(new Product(1,"Hat",20,200));
		list.add(new Product(2,"Shoes",20,200));
		list.add(new Product(3,"Jean",20,200));
		list.add(new Product(4,"T-Shirt",20,200));
		list.add(new Product(5,"Coat",20,200));
		list.add(new Product(6,"Skirt",20,200));
	}
	
	@Override
	public void add(Product product) {
		list.add(product);
	}
	
	@Override
	public void remove(int productId) {
		list.removeIf(item->item.getProductId()==productId);
	}
	
	@Override
	public List<Product> getAll(){
		return list;
	}
	
	@Override
	public Product findById(int productId) {
		return list.get(productId);
	}
	
	@Override
	public void update(Product product) {
		for(var i=0;i<list.size();i++) {
			Product item=list.get(i);
			if (item.getProductId()==product.getProductId()) {
				list.set(i, product);
				break;
			}
		}
	}
}
