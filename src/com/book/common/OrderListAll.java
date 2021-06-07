package com.book.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.notice.serviceImpl.NoticeServiceImpl;
import com.book.notice.vo.NoticeVO;
import com.book.order.service.OrderService;
import com.book.order.serviceImpl.OrderServiceImpl;
import com.book.order.vo.OrderVO;

public class OrderListAll implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");	// 페이지번호
		
		if(page == null) 
			page= "1";
		
		int pageCnt = Integer.parseInt(page);

		OrderServiceImpl service = new OrderServiceImpl();
		List<OrderVO> total =  service.selectOrderListAll();	//	 전체 카운트
		
		service = new OrderServiceImpl();
		List<OrderVO> list = service.orderListAdminPaging(pageCnt);
		
		
        Paging paging = new Paging();
        paging.setPageNo(pageCnt);
        paging.setPageSize(10);
        paging.setTotalCount(total.size());

        request.setAttribute("paging", paging);
        request.setAttribute("orderList", list);
        
		return "order/orderList.tiles";
	}


}
