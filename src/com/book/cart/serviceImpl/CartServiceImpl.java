package com.book.cart.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.cart.service.CartService;
import com.book.cart.vo.CartVO;
import com.book.common.DAO;

public class CartServiceImpl extends DAO implements CartService {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	// 아이디에 일치하는 장바구니 상품 리스트 조회
	@Override
	public List<CartVO> selectCartList(String id) {
		conn = DAO.getConnect();
		sql ="select n.book_image,n.book_code, n.book_name, n.price, n.sale, n.sale_price,count(c.book_code) cnt, n.sale_price*count(c.book_code) ssum\r\n"
				+ ", n.price*count(c.book_code) sum\r\n"
				+ "from cart c ,book n \r\n"
				+ "where c.BOOK_CODE= n.BOOK_CODE \r\n"
				+ "and user_id= ? \r\n"
				+ "group by n.book_image, n.book_code,n.book_name, n.price, n.sale, n.sale_price ";
		List<CartVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs= psmt.executeQuery();
			
			while(rs.next()) {
				CartVO vo = new CartVO();
				vo.setBookImage(rs.getString("book_image"));
				vo.setBookCode(rs.getString("book_code"));
				vo.setBookName(rs.getString("book_name"));
				vo.setPrice(rs.getString("price"));
				vo.setSalePrice(rs.getString("sale_price"));
				vo.setSale(rs.getString("sale"));
				vo.setSsum(rs.getInt("ssum"));
				vo.setSum(rs.getInt("sum"));
				vo.setCnt(rs.getInt("cnt"));
				list.add(vo);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
 
	@Override
	public CartVO selectCart(CartVO vo) {
		conn = DAO.getConnect();
		return null;
	}

	// 장바구니 담기
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
