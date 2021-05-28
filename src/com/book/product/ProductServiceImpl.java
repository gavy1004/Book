package com.book.product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.common.DAO;
import com.book.product.service.ProductService;
import com.book.product.vo.ProductVO;

public class ProductServiceImpl extends DAO implements ProductService {
	
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	
	@Override
	public List<ProductVO> selectProductList() {
		sql ="select * from novel";
		List<ProductVO> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs= psmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setBookCode(rs.getString("bookCode"));
				vo.setBookImage(rs.getString("bookImage"));
				vo.setBookName(rs.getString("bookName"));
				vo.setContents(rs.getString("contents"));
				vo.setPrice(rs.getString("price"));
				vo.setSale(rs.getString("sale"));
				vo.setSalePrice(rs.getString("salePrice"));
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
