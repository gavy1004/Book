package com.book.product.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.admin.web.ProductList;
import com.book.common.DBCommand;
import com.book.member.service.MemberService;
import com.book.product.service.ProductService;
import com.book.product.serviceImpl.ProductServiceImpl;
import com.book.product.vo.ProductVO;

public class ProductDelete implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("bookCode");
		
		ProductVO vo = new ProductVO();
		vo.setBookCode(code);
		
		ProductService service = new ProductServiceImpl();
		service.deleteProduct(vo);
		
		DBCommand command = new ProductList();
		command.execute(request, response);

		request.setAttribute("product", vo);
		System.out.println(code);
		return "admin/productList.tiles";
	}

}
