package com.book.cart.service;

import java.util.List;

import com.book.cart.vo.CartVO;


public interface CartService {
	// 전체조회, 한건조회, 입력, 수정, 삭제
	List<CartVO> selectCartList(String id);
	public boolean selectCart(CartVO vo);
	public int insertCart(CartVO vo);
	public int updateCart(CartVO vo);
	public int deleteCart(CartVO vo);
	public int deleteAllCart(CartVO vo);
	
	public int getCountCart(String id);		// 장바구니 물품 개수
	
}
