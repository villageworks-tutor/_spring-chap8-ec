package com.example.demo.model;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.example.demo.entity.Item;

class CartTest {

	/** テスト対象クラス */
	private Cart sut;
	
	@BeforeEach
	void setUp() throws Exception {
		sut = new Cart();
	}
	
	@Nested
	@DisplayName("Cart#add(Item)メソッドのテストクラス")
	class AddTest {
		@ParameterizedTest
		@MethodSource("provideTestAddParams")
		@DisplayName("【Test】商品追加後の商品リストを比較するテスト")
		void testAdd(List<Item> targetList, List<Item> expectedList) {
			// execute
			for (Item target : targetList) {
				sut.add(target);
			}
			// verify
			List<Item> actualList = sut.getItemList();
			if (actualList.size() > 0) {
				for (int i = 0; i < actualList.size(); i++) {
					String actual = actualList.get(i).toString();
					String expected = expectedList.get(i).toString();
					assertThat(actual, is(expected));
				}
			} else {
				fail("まだ実装されていません");
			}
		}
		/**
		 * Test-01用のテストパラメータを生成する
		 * @return テストパラメータリストを要素とするStream
		 */
		static Stream<Arguments> provideTestAddParams() {
			//  setup
			List<Item> targetList = null;
			List<List<Item>> targets = new ArrayList<>();
			List<Item> expectedList = null;
			List<List<Item>> expected = new ArrayList<>();
			
			// Case-1: 商品がカートに入っていない状態で商品を追加できる
			targetList = new ArrayList<>();
			targetList.add(new Item(101, 1, "鼻行類", 2000));
			targets.add(targetList);
			expectedList = new ArrayList<>();
			expectedList.add(new Item(101, 1, "鼻行類", 2000));
			expected.add(expectedList);
			
			// Case-2: 商品がすでにカートに入っている状態でカート内に入っていない商品を追加できる
			targetList = new ArrayList<>();
			targetList.add(new Item(101, 1, "鼻行類", 2000));
			targetList.add(new Item(102, 2, "帝都物語", 1800));
			targetList.add(new Item(103, 3, "黒ひげ危機一発", 3200));
			targetList.add(new Item(104, 2, "太平記", 1500));
			targets.add(targetList);
			expectedList = new ArrayList<>();
			expectedList.add(new Item(101, 1, "鼻行類", 2000));
			expectedList.add(new Item(102, 2, "帝都物語", 1800));
			expectedList.add(new Item(103, 3, "黒ひげ危機一発", 3200));
			expectedList.add(new Item(104, 2, "太平記", 1500));
			expected.add(expectedList);
			
			// Case-3: 商品がすでにカートに入っている状態ですでに入っている商品を追加できる
			targetList = new ArrayList<>();
			targetList.add(new Item(101, 1, "鼻行類", 2000));
			targetList.add(new Item(102, 2, "帝都物語", 1800));
			targetList.add(new Item(103, 3, "黒ひげ危機一発", 3200));
			targetList.add(new Item(102, 2, "帝都物語", 1800));
			targets.add(targetList);
			expectedList = new ArrayList<>();
			expectedList.add(new Item(101, 1, "鼻行類", 2000));
			expectedList.add(new Item(102, 2, "帝都物語", 1800));
			expectedList.get(1).setQuantity(2);
			expectedList.add(new Item(103, 3, "黒ひげ危機一発", 3200));
			expected.add(expectedList);
			
			
			// テストパラメータを返却
			return Stream.of(
					  Arguments.of(targets.get(0), expected.get(0))
					, Arguments.of(targets.get(1), expected.get(1))
					, Arguments.of(targets.get(2), expected.get(2))
					);
		}
		
	}

}
