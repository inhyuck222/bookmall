package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.dao.utils.MySqlConnection;
import com.cafe24.bookmall.vo.CategoryVo;

public class CategoryDao {
	
	public List<CategoryVo> select(){
		List<CategoryVo> list = new ArrayList<CategoryVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = MySqlConnection.getConnection();
			
			String sql = 
					" select " + 
					"		no, " + 
					"		name " + 
					" from category";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			CategoryVo vo;
			while(rs.next()) {
				vo = new CategoryVo();				
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				
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

	public boolean insert(CategoryVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			
			conn = MySqlConnection.getConnection();

			String sql = "insert into category values(?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getNo());
			pstmt.setString(2, vo.getName());

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
