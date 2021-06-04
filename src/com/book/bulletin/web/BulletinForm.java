package com.book.bulletin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.common.DBCommand;
import com.book.order.serviceImpl.OrderServiceImpl;
import com.book.order.vo.OrderVO;

public class BulletinForm implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String code = request.getParameter("code");
		String bookCode = request.getParameter("bookCode");

		OrderVO vo = new OrderVO();
		vo.setCode(code);
		vo.setBookCode(bookCode);

		OrderServiceImpl service = new OrderServiceImpl();
		service.selectBookCodeCheck(vo);

		request.setAttribute("order", vo);

		return "bulletin/bulletinForm.tiles";
	}

}
