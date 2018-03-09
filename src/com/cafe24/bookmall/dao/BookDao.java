package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.dao.utils.MySqlConnection;
import com.cafe24.bookmall.vo.BookVo;

public class BookDao {
	
	public List<BookVo> select(){
		List<BookVo> list = new ArrayList<BookVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = MySqlConnection.getConnection();
			
			String sql = 
					" select " + 
					"	no, " + 
					"    name, " + 
					"    cost, "+ 
					"    category_no " + 
					" from book";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			BookVo vo;
			while(rs.next()) {
				vo = new BookVo();				
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setCost(rs.getLong(3));
				vo.setCategoryNo(rs.getLong(4));
				
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

	public boolean insert(BookVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			
			conn = MySqlConnection.getConnection();

			String sql = "insert into book values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getNo());
			pstmt.setString(2, vo.getName());
			pstmt.setLong(3, vo.getCost());
			pstmt.setLong(4, vo.getCategoryNo());

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
