package com.book.order.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.common.DBCommand;
import com.book.common.Paging;
import com.book.order.serviceImpl.OrderServiceImpl;
import com.book.order.vo.OrderVO;

public class OrderList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page"); // 페이지번호
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		if (page == null)
			page = "1";

		int pageCnt = Integer.parseInt(page);

		OrderServiceImpl service = new OrderServiceImpl();
		List<OrderVO> total = service.selectOrderList(id); // 전체 카운트

		service = new OrderServiceImpl();
		List<OrderVO> list = service.orderListPaging(pageCnt, id);

		Paging paging = new Paging();
		paging.setPageNo(pageCnt);
		paging.setPageSize(10);
		paging.setTotalCount(total.size());

		request.setAttribute("paging", paging);
		request.setAttribute("orderList", list);

		return "order/orderList.tiles";
	}

}
