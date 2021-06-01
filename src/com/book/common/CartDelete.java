package com.book.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.cart.service.CartService;
import com.book.cart.serviceImpl.CartServiceImpl;
import com.book.cart.vo.CartVO;

public class CartDelete implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		String bookCode = request.getParameter("bookCode");
		CartVO vo = new CartVO();
		vo.setBookCode(bookCode);
		vo.setUserId(id);

		CartService service = new CartServiceImpl();
		service.deleteCart(vo);

		return "/cartList.do";
	}

}
