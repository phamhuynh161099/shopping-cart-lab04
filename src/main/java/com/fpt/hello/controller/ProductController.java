package com.fpt.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpt.hello.service.ProductService;

@Controller
@RequestMapping("products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("products",productService.getAll());
		return "products/list";
	}
}
