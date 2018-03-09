package com.cafe24.bookmall.dao.test;

import java.util.List;

import com.cafe24.bookmall.dao.OrderDao;
import com.cafe24.bookmall.vo.OrderBookVo;
import com.cafe24.bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		// insertOrderTest();
		// selectOrderTest();

		// insertOrderBookTest();
		// selectOrderBookTest();
	}

	public static void selectOrderTest() {
		OrderDao dao = new OrderDao();

		List<OrderVo> list = dao.selectOrder();

		for (OrderVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void insertOrderTest(OrderVo vo) {
		if(vo == null) {
			return;
		}
		OrderDao dao = new OrderDao();

		dao.insertOrder(vo);
	}

	public static void selectOrderBookTest() {
		OrderDao dao = new OrderDao();

		List<OrderBookVo> list = dao.selectOrderBook();

		for (OrderBookVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void insertOrderBookTest(OrderBookVo vo) {
		if(vo == null) {
			return;
		}
		OrderDao dao = new OrderDao();

		dao.insertOrderBook(vo);
	}

}
