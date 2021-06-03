package com.book.cart.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.HttpRequestMethodNotSupportedException;

import com.book.cart.service.CartService;
import com.book.cart.serviceImpl.CartServiceImpl;
import com.book.cart.vo.CartVO;
import com.book.common.DBCommand;

public class CartUpdate implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String bookCode = request.getParameter("bookCode");
		String id = (String) session.getAttribute("id");
		String bookQty = request.getParameter("cnt");
				
		System.out.println(bookCode);
		System.out.println(bookQty);
		System.out.println(id);
		
		CartVO vo =new CartVO();
		vo.setBookCode(bookCode);
		vo.setUserId(id);
		vo.setBookQty(Integer.parseInt(bookQty));
	


		CartService service = new CartServiceImpl();
		service.updateCartPage(vo);
		
		request.setAttribute("cart", vo);
		
		return "/cartList.do";
	}

}
