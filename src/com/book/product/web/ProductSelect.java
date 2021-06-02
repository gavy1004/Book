package com.book.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.common.DBCommand;
import com.book.product.service.ProductService;
import com.book.product.serviceImpl.ProductServiceImpl;
import com.book.product.vo.ProductVO;

public class ProductSelect implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String cd = request.getParameter("bookCode");

		ProductVO vo = new ProductVO();
		vo.setBookCode(cd);

		ProductService service = new ProductServiceImpl();
		service.selectProduct(vo);

		request.setAttribute("product", vo);

		return "product/productSelect.tiles";
	}

}
