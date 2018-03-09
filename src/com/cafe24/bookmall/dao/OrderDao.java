package com.cafe24.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.bookmall.dao.utils.MySqlConnection;
import com.cafe24.bookmall.vo.OrderBookVo;
import com.cafe24.bookmall.vo.OrderVo;

public class OrderDao {	
	public List<OrderVo> selectOrder() {
		List<OrderVo> list = new ArrayList<OrderVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = MySqlConnection.getConnection();

			String sql = 
					" SELECT " + 
					"	no, " + 
					" 	name, " + 
					" 	payment, " + 
					"	destination, " + 
					" 	member_no " + 
					" FROM bookmall.order ";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			OrderVo vo;
			while (rs.next()) {
				vo = new OrderVo();
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				vo.setPayment(rs.getLong(3));
				vo.setDestination(rs.getString(4));
				vo.setMemberNo(rs.getLong(5));

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

	public boolean insertOrder(OrderVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = MySqlConnection.getConnection();

			String sql = 
					" insert " + 
					"	into bookmall.order " + 
					"    values(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getNo());
			pstmt.setString(2, vo.getName());
			pstmt.setLong(3, vo.getPayment());
			pstmt.setString(4, vo.getDestination());
			pstmt.setLong(5, vo.getMemberNo());

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
	
	public List<OrderBookVo> selectOrderBook() {
		List<OrderBookVo> list = new ArrayList<OrderBookVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = MySqlConnection.getConnection();

			String sql = 
					" select " + 
					"	book_no, " + 
					"    order_no, " + 
					"    amount, " + 
					"    cost " + 
					" from order_book ";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			OrderBookVo vo;
			while (rs.next()) {
				vo = new OrderBookVo();				
				vo.setBookNo(rs.getLong(1));
				vo.setOrderNo(rs.getLong(2));
				vo.setAmount(rs.getLong(3));
				vo.setCost(rs.getLong(4));

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

	public boolean insertOrderBook(OrderBookVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = MySqlConnection.getConnection();

			String sql = 
					" insert " + 
					"	into order_book " + 
					"    values(?, ?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getBookNo());
			pstmt.setLong(2, vo.getOrderNo());
			pstmt.setLong(3, vo.getAmount());
			pstmt.setLong(4, vo.getCost());

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
