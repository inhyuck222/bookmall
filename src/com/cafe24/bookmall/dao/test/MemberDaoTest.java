package com.cafe24.bookmall.dao.test;

import java.util.List;

import com.cafe24.bookmall.dao.MemberDao;
import com.cafe24.bookmall.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		// insertTest();
		// selectTest();
	}

	public static void selectTest() {
		MemberDao dao = new MemberDao();

		List<MemberVo> list = dao.select();

		for (MemberVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void insertTest(MemberVo vo) {
		if(vo == null) {
			return;
		}
		MemberDao dao = new MemberDao();
		
		dao.insert(vo);
	}
	
}
