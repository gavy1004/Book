package com.book.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.product.ProductServiceImpl;
import com.book.product.service.ProductService;
import com.book.product.vo.ProductVO;

public class NovelList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ProductService service = new ProductServiceImpl();
		List<ProductVO> list = service.selectProductList();
		
		request.setAttribute("list", list);
		System.out.println("성공");
		return "layout/section.tiles";
	}

}
