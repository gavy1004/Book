package com.book.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.cart.service.CartService;
import com.book.cart.serviceImpl.CartServiceImpl;
import com.book.cart.vo.CartVO;

public class CartInsert implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String bookCode = request.getParameter("bookCode");
		String id = (String) session.getAttribute("id");
		
		CartVO vo =new CartVO();
		vo.setBookCode(bookCode);
		vo.setUserId(id);
		
		CartService service = new CartServiceImpl();
		service.insertCart(vo);
		
		request.setAttribute("cart", vo);
		
		return "/novelSelect.do";
	}

}
