package com.book.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.cart.service.CartService;
import com.book.cart.serviceImpl.CartServiceImpl;
import com.book.cart.vo.CartVO;

public class CartSelectInsert implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String bookCode = request.getParameter("bookCode");
		String id = (String) session.getAttribute("id");
		
		CartVO vo =new CartVO();
		vo.setBookCode(bookCode);
		vo.setUserId(id);
		
		CartService service = new CartServiceImpl();
		if(	service.selectCart(vo)) {
			service.updateCart(vo);
			System.out.println("조회 결과가 있습니다 수정합니다");
		} else{
			service.insertCart(vo);
			System.out.println("조회 결과가 없습니다 입력합니다");
		}
		
		int cartCnt = service.getCountCart(id);
		
		session.setAttribute("cartCnt", cartCnt);
		request.setAttribute("cart", vo);
		
		return "/novelSelect.do";
	}

}
