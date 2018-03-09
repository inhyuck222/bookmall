package com.cafe24.bookmall.dao.test;

import java.util.List;

import com.cafe24.bookmall.dao.CartDao;
import com.cafe24.bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		// insertTest();
		// selectTest();
	}

	public static void selectTest() {
		CartDao dao = new CartDao();

		List<CartVo> list = dao.select();

		for (CartVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void insertTest(CartVo vo) {
		if(vo == null) {
			return;
		}
		
		CartDao dao = new CartDao();	
		
		dao.insert(vo);
	}

}
