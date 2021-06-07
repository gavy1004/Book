package com.book.order.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.admin.web.ProductList;
import com.book.cart.serviceImpl.CartServiceImpl;
import com.book.cart.vo.CartVO;
import com.book.common.DBCommand;
import com.book.order.service.OrderService;
import com.book.order.serviceImpl.OrderServiceImpl;
import com.book.order.vo.OrderVO;

public class OrderInsert implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String name = request.getParameter("name");
		String adress = request.getParameter("adress");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String coments = request.getParameter("coments");
		
		String qty = request.getParameter("qty");
		String bookCode = request.getParameter("bookCode");
		String sum = request.getParameter("sum");
		
		
		System.out.println(name);
		System.out.println(phone);
		System.out.println(email);
		System.out.println(adress);

		
		OrderVO vo = new OrderVO();
		vo.setName(name);
		vo.setAdress(adress);
		vo.setPhone(phone);
		vo.setEmail(email);
		vo.setComents(coments);

		OrderService service = new OrderServiceImpl();
		int order = service.insertOrder(vo);
		
		//카트비우기
		CartServiceImpl cartservice = new CartServiceImpl();
		CartVO cartvo = new CartVO();
		cartvo.setUserId((String) session.getAttribute("id")); 
		cartservice.deleteAllCart(cartvo);
		
		DBCommand command = new ProductList();
		command.execute(request, response);
		
		request.setAttribute("order", vo);

		return "order/orderList.tiles";
	}

}
