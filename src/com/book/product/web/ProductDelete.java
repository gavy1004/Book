package com.book.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.common.DBCommand;
import com.book.member.service.MemberService;
import com.book.product.service.ProductService;

public class ProductDelete implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("bookCode");
		
		ProductService service = ProductService.
		return null;
	}

}
