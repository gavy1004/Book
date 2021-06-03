package com.book.order.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.common.DBCommand;
import com.book.order.service.OrderService;
import com.book.order.serviceImpl.OrderServiceImpl;
import com.book.order.vo.OrderVO;

public class OrderSelect implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String od = request.getParameter("code");
		
		OrderVO vo = new OrderVO();
		vo.setCode(od);
		
		OrderService service = new OrderServiceImpl();
		service.selectOrder(vo);
		
		request.setAttribute("order", vo);
		
		return "order/orderSelect.tiles";
	}

}
