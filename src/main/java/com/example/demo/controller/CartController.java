package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Cart;

@Controller
public class CartController {
	
	@Autowired
	private Cart cart;
	
	// カート画面表示
	@GetMapping("/cart")
	public String  index() {
		return "cart";
	}
}
