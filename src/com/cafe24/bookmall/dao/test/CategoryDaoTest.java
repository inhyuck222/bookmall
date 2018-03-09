package com.cafe24.bookmall.dao.test;

import java.util.List;
import java.util.Locale.Category;

import com.cafe24.bookmall.dao.CategoryDao;
import com.cafe24.bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		// insertTest();
		selectTest();
	}

	public static void selectTest() {
		CategoryDao dao = new CategoryDao();

		List<CategoryVo> list = dao.select();

		for (CategoryVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void insertTest(CategoryVo vo) {
		if(vo == null) {
			return;
		}
		CategoryDao dao = new CategoryDao();

		dao.insert(vo);
	}

}
