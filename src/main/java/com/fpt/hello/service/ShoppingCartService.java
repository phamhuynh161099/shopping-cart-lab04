package com.fpt.hello.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.fpt.hello.model.CartItem;

@Service
@SessionScope
public interface ShoppingCartService {

	int getCount();

	double getAmount();

	void update(int productId, int quantity);

	void clear();

	Collection<CartItem> getCartItems();

	void remove(int productId);

	void add(CartItem item);

}
