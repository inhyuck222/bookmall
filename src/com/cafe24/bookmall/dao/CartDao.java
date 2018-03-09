package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.dao.utils.MySqlConnection;
import com.cafe24.bookmall.vo.CartVo;

public class CartDao {

	public List<CartVo> select(){
		List<CartVo> list = new ArrayList<CartVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = MySqlConnection.getConnection();
			
			String sql = 
					" select " + 
					"	amount, " + 
					"    member_no, " + 
					"    book_no " + 
					" from cart ";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			CartVo vo;
			while(rs.next()) {
				vo = new CartVo();
				vo.setAmount(rs.getLong(1));
				vo.setMemberNo(rs.getLong(2));
				vo.setBookNo(rs.getLong(3));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (conn != null && conn.isClosed() == false) {
					conn.close();
				}
				if (pstmt != null && pstmt.isClosed() == false) {
					pstmt.close();
				}
				if (rs != null && rs.isClosed() == false) {
					rs.close();
				}
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
		
		return list;
	}

	public boolean insert(CartVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			
			conn = MySqlConnection.getConnection();

			String sql = "insert into cart values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getAmount());
			pstmt.setLong(2, vo.getMemberNo());
			pstmt.setLong(3, vo.getBookNo());

			int count = pstmt.executeUpdate();
			result = (count == 1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (conn != null && conn.isClosed() == false) {
					conn.close();
				}
				if (pstmt != null && pstmt.isClosed() == false) {
					pstmt.close();
				}
				
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}

		return result;
	}

}
