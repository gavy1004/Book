package com.book.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.product.ProductServiceImpl;
import com.book.product.service.ProductService;
import com.book.product.vo.ProductVO;

public class NovelSelect implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String bookcode = request.getParameter("bookCode");
		System.out.println(bookcode);
		
		ProductVO vo =new ProductVO();
		vo.setBookCode(bookcode); 
		
		ProductService service = new ProductServiceImpl();
		service.selectProduct(vo);
		
		request.setAttribute("book", vo);
		return "product/novelSelect.tiles";
	}
}
