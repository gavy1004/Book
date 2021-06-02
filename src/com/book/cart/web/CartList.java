package com.book.cart.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.cart.service.CartService;
import com.book.cart.serviceImpl.CartServiceImpl;
import com.book.cart.vo.CartVO;
import com.book.common.DBCommand;

public class CartList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		CartVO vo = new CartVO();
		vo.setUserId(id);
		
		CartService service = new CartServiceImpl();
		List<CartVO> list = service.selectCartList(id);
		
		int cartCnt = service.getCountCart(id);
		System.out.println(cartCnt);
		
		session.setAttribute("cartCnt",cartCnt);
		request.setAttribute("cartList", list );
		return "cart/cartList.tiles";
	}

}
