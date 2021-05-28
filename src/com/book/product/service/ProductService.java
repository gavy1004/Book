package com.book.product.service;

import java.util.List;

import com.book.product.vo.ProductVO;

public interface ProductService {
	// 전체조회, 한건조회, 입력, 수정, 삭제
	List<ProductVO> selectProductList();
	ProductVO selectProduct();
	public int insertProduct(ProductVO vo);
	public int updateProduct(ProductVO vo);
	public int deleteProduct(ProductVO vo);
}
