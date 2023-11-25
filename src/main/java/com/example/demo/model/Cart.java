package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.entity.Item;

@Component
@SessionScope
public class Cart {

	/**
	 * フィールド
	 */
	private List<Item> itemList = new ArrayList<>();

	/**
	 * 商品リストフィールドを取得する
	 * @return List<Item> 商品リスト
	 */
	public List<Item> getItemList() {
		return this.itemList;
	}

}
