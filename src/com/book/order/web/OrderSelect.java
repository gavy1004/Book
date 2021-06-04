package com.book.order.web;

import java.util.List;

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
		List<OrderVO> list = service.selectOrderListOne(vo);
		
		
		request.setAttribute("order", list);
		
		return "order/orderSelectList.tiles";
	}

}
