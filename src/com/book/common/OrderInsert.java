package com.book.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.order.service.OrderService;
import com.book.order.serviceImpl.OrderServiceImpl;
import com.book.order.vo.OrderVO;

public class OrderInsert implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String adress = request.getParameter("adress");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String coments = request.getParameter("coments");
		
		OrderVO vo = new OrderVO();
		vo.setCode(code);
		vo.setAdress(adress);
		vo.setName(name);
		vo.setPhone(phone);
		vo.setEmail(email);
		vo.setComents(coments);
		
		OrderService service = new OrderServiceImpl();
	
		int order = service.insertOrder(vo);
		
		request.setAttribute("order", vo);
		
		return null;
	}

}
