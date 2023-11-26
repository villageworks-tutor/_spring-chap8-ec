package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Customer;

@Controller
public class OrderController {
	
	// 顧客情報入力画面表示
	@GetMapping("/order")
	public String index() {
		return "customerForm";
	}
	
	// 注文内容確認画面表示
	@PostMapping("/order/confirm")
	public String confirm(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "address", defaultValue = "") String address,
			@RequestParam(name = "tel", defaultValue = "") String tel,
			@RequestParam(name = "email", defaultValue = "") String email,
			Model model) {
		// リクエストパラメータをもとにして顧客のインスタンスを生成
		Customer customer = new Customer(name, address, tel, email);
		// スコープに登録
		model.addAttribute("customer", customer);
		// 画面遷移
		return "orderConfirm";
	}
}
