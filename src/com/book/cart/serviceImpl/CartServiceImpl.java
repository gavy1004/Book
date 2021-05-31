package com.book.cart.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.book.cart.service.CartService;
import com.book.cart.vo.CartVO;
import com.book.common.DAO;

public class CartServiceImpl extends DAO implements CartService {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	@Override
	public List<CartVO> selectCartList() {
		conn = DAO.getConnect();
		return null;
	}

	@Override
	public CartVO selectCart(CartVO vo) {
		conn = DAO.getConnect();
		return null;
	}

	@Override
	public int insertCart(CartVO vo) {
		conn = DAO.getConnect();
		sql = "insert into cart values(? ,? ,'1')";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUserId());
			psmt.setString(2, vo.getBookCode());
			r = psmt.executeUpdate();
			System.out.println(r + "건이 장바구니에 입력되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return 0;
	}

	@Override
	public int updateCart(CartVO vo) {
		conn = DAO.getConnect();
		return 0;
	}

	@Override
	public int deleteCart(CartVO vo) {
		conn = DAO.getConnect();
		return 0;
	}

	private void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
