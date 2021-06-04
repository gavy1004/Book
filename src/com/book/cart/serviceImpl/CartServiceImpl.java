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
import com.book.product.vo.ProductVO;

public class CartServiceImpl extends DAO implements CartService {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	// 아이디에 일치하는 장바구니 상품 리스트 조회
	@Override
	public List<CartVO> selectCartList(String id) {
		conn = DAO.getConnect();
		sql = "select n.book_image, n.book_code,n.book_name, n.price, n.sale, n.sale_price,sum(c.book_qty) cnt, n.sale_price*sum(c.book_qty) ssum\r\n"
				+ ", n.price*sum(c.book_qty) sum\r\n" + "from cart c ,book n \r\n"
				+ "where c.BOOK_CODE= n.BOOK_CODE \r\n" + "and user_id=?\r\n"
				+ "group by n.book_image,n.book_code, n.book_name, n.price, n.sale, n.sale_price ";
		List<CartVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			while (rs.next()) {
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
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	// 회원별 장바구니 상품 갯수 
	public int getCountCart(String id) {
		conn = DAO.getConnect();
		sql ="select sum(book_qty) cnt from cart where user_id=?";
		int rCnt = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				rCnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return rCnt;
	}

	// 장바구니 중복체크 / 중복존재하면 true / 아니면 False
	// 같은 상품이 담겨 있는지 조회
	@Override
	public boolean selectCart(CartVO vo) {
		boolean exist = false;
		conn = DAO.getConnect();
		sql = "select * from cart where user_id =? and book_code=?"; 
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUserId());
			psmt.setString(2, vo.getBookCode());
			rs = psmt.executeQuery();
			if (rs.next()) {
				exist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return exist;
	}

	// 같은 상품이 없다면 등록
	@Override
	public int insertCart(CartVO vo) {
		conn = DAO.getConnect();
		sql = "insert into cart values(? ,? ,1)"; 
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUserId());
			psmt.setString(2, vo.getBookCode());
			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}

	// 같은 상품이 있다면 1 추가
	@Override
	public int updateCart(CartVO vo) {
		conn = DAO.getConnect();
		sql = "UPDATE cart set book_qty=book_qty+1 where user_id = ? and book_code=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUserId());
			psmt.setString(2, vo.getBookCode());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}
	
	@Override
	public int updateCartPage(CartVO vo) {
		conn = DAO.getConnect();
		sql="update cart set book_qty=? where user_id=? and book_code=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getBookQty());
			psmt.setString(2, vo.getUserId());
			psmt.setString(3, vo.getBookCode());
			
			int r =psmt.executeUpdate();
			System.out.println(r+"건이 수정되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return 0;
	}
	
	/*
	 * // 장바구니 조회 페이지에서 수량감소
	 * 
	 * @Override public int DecQtyUpdate(CartVO vo) { conn = DAO.getConnect(); sql =
	 * "UPDATE cart set book_qty=book_qty-1 where user_id = ? and book_code=?"; int
	 * r = 0; try { psmt = conn.prepareStatement(sql); psmt.setString(1,
	 * vo.getUserId()); psmt.setString(2, vo.getBookCode());
	 * 
	 * r =psmt.executeUpdate(); System.out.println(r+"건이 업데이트 되었습니다");
	 * System.out.println(vo.getBookCode()); System.out.println(vo.getUserId());
	 * System.out.println(vo.getBookQty()); } catch (SQLException e) {
	 * e.printStackTrace(); } finally { close(); } return r; }
	 */
	
	@Override
	public int deleteCart(CartVO vo) {
		conn = DAO.getConnect();
		sql = "DELETE FROM cart WHERE user_id = ? AND book_code=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUserId());
			psmt.setString(2, vo.getBookCode());
			int r = psmt.executeUpdate();
			System.out.println(r + "건이 카트에서 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0;
	}
	
	@Override
	public int deleteAllCart(CartVO vo) {
		conn = DAO.getConnect();
		sql = "DELETE FROM cart WHERE user_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUserId());
			int r = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
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
