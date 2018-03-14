package com.cafe24.bookmall.app;

import com.cafe24.bookmall.dao.test.BookDaoTest;
import com.cafe24.bookmall.dao.test.CartDaoTest;
import com.cafe24.bookmall.dao.test.CategoryDaoTest;
import com.cafe24.bookmall.dao.test.MemberDaoTest;
import com.cafe24.bookmall.dao.test.OrderDaoTest;
import com.cafe24.bookmall.vo.BookVo;
import com.cafe24.bookmall.vo.CartVo;
import com.cafe24.bookmall.vo.CategoryVo;
import com.cafe24.bookmall.vo.MemberVo;
import com.cafe24.bookmall.vo.OrderBookVo;
import com.cafe24.bookmall.vo.OrderVo;

public class BookMallApp {

	public static void main(String[] args) {
		insertAllData();
		selectAllData();
	}

	public static void insertAllData() {
		CategoryDaoTest.insertTest(new CategoryVo(1, "computer"));
		CategoryDaoTest.insertTest(new CategoryVo(2, "comic"));

		BookDaoTest.insertTest(new BookVo(1, "진격의거인", 5000, 2));
		BookDaoTest.insertTest(new BookVo(2, "원피스", 5000, 2));
		BookDaoTest.insertTest(new BookVo(3, "java", 5000, 1));

		MemberDaoTest.insertTest(new MemberVo(1, "보리", "010-3333-5555", "bori@yoonsoon.home", "124512"));
		MemberDaoTest.insertTest(new MemberVo(2, "금순이", "010-5555-5555", "goldSooni@zzil.home", "115121"));

		OrderDaoTest.insertOrderTest(new OrderVo(1, "보리주문", 15000, "미리내 마을", 1));

		OrderDaoTest.insertOrderBookTest(new OrderBookVo(1, 1, 2, 5000));
		OrderDaoTest.insertOrderBookTest(new OrderBookVo(2, 1, 1, 5000));

		CartDaoTest.insertTest(new CartVo(2, 2, 2));
		CartDaoTest.insertTest(new CartVo(3, 1, 1));
	}

	public static void selectAllData() {
		System.out.println("===Member============================================================");
		MemberDaoTest.selectTest();
		System.out.println();

		System.out.println("===Cart============================================================");
		CartDaoTest.selectTest();
		System.out.println();

		System.out.println("===Book============================================================");
		BookDaoTest.selectTest();
		System.out.println();

		System.out.println("===Order============================================================");
		OrderDaoTest.selectOrderTest();
		System.out.println();

		System.out.println("===OrderBook============================================================");
		OrderDaoTest.selectOrderBookTest();
		System.out.println();
	}

}
