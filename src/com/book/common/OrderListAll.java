package com.book.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.order.service.OrderService;
import com.book.order.serviceImpl.OrderServiceImpl;
import com.book.order.vo.OrderVO;

public class OrderListAll implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		OrderService service = new OrderServiceImpl();
		List<OrderVO> list = service.selectOrderListAll();
		
		request.setAttribute("orderList", list);

		return "order/orderList.tiles";
	}


}
