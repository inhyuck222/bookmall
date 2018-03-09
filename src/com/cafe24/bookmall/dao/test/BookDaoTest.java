package com.cafe24.bookmall.dao.test;

import java.util.List;

import com.cafe24.bookmall.dao.BookDao;
import com.cafe24.bookmall.vo.BookVo;

public class BookDaoTest {
	
	public static void main(String[] args) {
		// insertTest();
		// selectTest();
	}

	public static void selectTest() {
		BookDao dao = new BookDao();

		List<BookVo> list = dao.select();

		for (BookVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void insertTest(BookVo vo) {
		if(vo == null) {
			return;
		}
		
		BookDao dao = new BookDao();
		
		dao.insert(vo);
	}
	
}
