package com.book.product.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.common.DAO;
import com.book.product.service.ProductService;
import com.book.product.vo.ProductVO;


public class ProductServiceImpl extends DAO implements ProductService {
	Connection conn;
	PreparedStatement psmt ;
	ResultSet rs;
	String sql;
	
	// 좋아요 추가
	@Override
	public int insertLikeIt(ProductVO vo) {
		sql = "update book set like_it= like_it +1 where book_code=? ";
		conn = DAO.getConnect();
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			r = psmt.executeUpdate();
			System.out.println(r+ "건입력되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return r;
	}

	// 전체 상품 조회
	@Override
	public List<ProductVO> selectProductList() {
		conn = DAO.getConnect();
		sql ="select * from book";
		List<ProductVO> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs= psmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setBookCode(rs.getString("book_code"));
				vo.setBookName(rs.getString("book_Name"));
				vo.setBookImage(rs.getString("book_Image"));
				vo.setContents(rs.getString("contents"));
				vo.setPrice(rs.getString("price"));
				vo.setSalePrice(rs.getString("sale_Price"));
				vo.setSale(rs.getString("sale"));
				vo.setWriter(rs.getString("writer"));
				vo.setCategory(rs.getString("category"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	// 소설조회
	@Override
	public List<ProductVO> selectNovelList() {
		conn = DAO.getConnect();
		sql ="select * from book where category='n'";
		List<ProductVO> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs= psmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setBookCode(rs.getString("book_code"));
				vo.setBookName(rs.getString("book_Name"));
				vo.setBookImage(rs.getString("book_Image"));
				vo.setContents(rs.getString("contents"));
				vo.setPrice(rs.getString("price"));
				vo.setSalePrice(rs.getString("sale_Price"));
				vo.setSale(rs.getString("sale"));
				vo.setWriter(rs.getString("writer"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	// 시조회
	@Override
	public List<ProductVO> selectPoemList() {
		conn = DAO.getConnect();
		sql ="select * from book where category='p'";
		List<ProductVO> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs= psmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setBookCode(rs.getString("book_code"));
				vo.setBookName(rs.getString("book_Name"));
				vo.setBookImage(rs.getString("book_Image"));
				vo.setContents(rs.getString("contents"));
				vo.setPrice(rs.getString("price"));
				vo.setSalePrice(rs.getString("sale_Price"));
				vo.setSale(rs.getString("sale"));
				vo.setWriter(rs.getString("writer"));
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
	public ProductVO selectProduct(ProductVO vo) {
		sql ="select * from book where book_Code=?";
		conn = DAO.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			rs= psmt.executeQuery();
			while(rs.next()) {
				vo.setBookCode(rs.getString("book_code"));
				vo.setBookImage(rs.getString("book_image"));
				vo.setBookName(rs.getString("book_name"));
				vo.setContents(rs.getString("contents"));
				vo.setPrice(rs.getString("price"));
				vo.setSale(rs.getString("sale"));
				vo.setSalePrice(rs.getString("sale_price"));
				vo.setWriter(rs.getString("writer"));
				vo.setLikeIt(rs.getInt("like_it"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public int insertProduct(ProductVO vo) {
		return 0;
	}

	@Override
	public int updateProduct(ProductVO vo) {
		return 0;
	}

	@Override
	public int deleteProduct(ProductVO vo) {
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
