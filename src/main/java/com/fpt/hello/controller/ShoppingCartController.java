package com.fpt.hello.controller;

import java.util.Collection;

import javax.websocket.server.PathParam;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpt.hello.model.CartItem;
import com.fpt.hello.model.Product;
import com.fpt.hello.service.ProductService;
import com.fpt.hello.service.ShoppingCartService;

@Controller
@RequestMapping("shoppingCart")
public class ShoppingCartController {
	@Autowired
	ProductService productService;
	
	@Autowired
	ShoppingCartService cartService;
	
	@GetMapping("list")
	public String list(Model model) {
		Collection<CartItem> cartItems=cartService.getCartItems();
		model.addAttribute("cartItems", cartItems);
		model.addAttribute("total",cartService.getAmount());
		model.addAttribute("noOfItems",cartService.getCount());
		
		return "shoppingCarts/list";
	}
	
	@GetMapping("add/{productId}")
	public String add(@PathVariable("productId") Integer productId) {
		Product product=productService.findById(productId);
		
		if (product!=null) {
			CartItem cartItem=new CartItem();
			BeanUtils.copyProperties(product, cartItem);
			cartItem.setQuantity(1);
			cartService.add(cartItem);
		}
		return "redirect:/shoppingCart/list";
	}
	
	@GetMapping("remove/{productId}")
	public String remove(@PathVariable("productId") Integer productId) {
		cartService.remove(productId);
		return "redirect:/shoppingCart/list";
	}
	
	@PostMapping("update")
	public String update() {
		return "redirect:/shoppingCart/list";
	}
	
	@GetMapping("clear")
	public String clear() {
		return "redirect:/shoppingCart/list";
	}
}
