package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;

@Controller
public class AccountController {
	
	@Autowired
	Account account;
	
	// ログイン画面表示
	@GetMapping({"/", "/login"})
	public String index() {
		// 画面遷移
		return "login";
	}
	
	// ログイン処理
	@PostMapping("/login")
	public String login(@RequestParam("name") String name) {
		// セッションスコープに登録されているアカウント情報にリクエストパラメータを設定
		account.setName(name);
		// 画面遷移
		return "items";
	}
}
