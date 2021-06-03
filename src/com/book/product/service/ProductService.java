package com.book.product.service;

import java.util.List;

import com.book.product.vo.ProductVO;

public interface ProductService {
	// 전체조회, 한건조회, 입력, 수정, 삭제
	List<ProductVO> selectProductList();		// 전체조회
	List<ProductVO> selectNovelList();			// 소설조회
	List<ProductVO> selectPoemList();			// 시 조회
	List<ProductVO> selectBestList();			// 베스트 조회
	ProductVO selectProduct(ProductVO vo);	
	public int insertProduct(ProductVO vo);
	public int updateProduct(ProductVO vo);
	public int deleteProduct(ProductVO vo);
	public int insertLikeIt(ProductVO vo);		// 좋아요 추가
}
