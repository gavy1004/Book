package com.book.order.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.common.DBCommand;
import com.book.order.service.OrderService;
import com.book.order.serviceImpl.OrderServiceImpl;
import com.book.order.vo.OrderVO;

public class OrderList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		OrderService service = new OrderServiceImpl();
		List<OrderVO> list = service.selectOrderList();
		
		request.setAttribute("orderList", list);
		
		return "order/orderList.tiles";
	}

}
