package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.dao.utils.MySqlConnection;
import com.cafe24.bookmall.vo.MemberVo;

public class MemberDao {
	public List<MemberVo> select() {
		List<MemberVo> list = new ArrayList<MemberVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = MySqlConnection.getConnection();

			String sql = 
					" select " + 
					"	no, " + 
					"   name, " + 
					"   phone, " + 
					"	email, " + 
					" 	password " + 
					" from member";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			MemberVo vo;
			while (rs.next()) {
				vo = new MemberVo();
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setPhone(rs.getString(3));
				vo.setEmail(rs.getString(4));

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

	public boolean insert(MemberVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = MySqlConnection.getConnection();

			String sql = "insert into member values(?, ?, ?, ?, password(?))";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getNo());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPassword());

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
