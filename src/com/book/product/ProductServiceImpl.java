package com.book.product;

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
	
	@Override
	public List<ProductVO> selectProductList() {
		
		sql ="select * from novel";
		List<ProductVO> list = new ArrayList<>();
		DAO.getConnect();
		conn = DAO.getConnect();
		
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
	public ProductVO selectProduct() {
		return null;
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
