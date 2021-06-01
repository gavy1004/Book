package com.book.admin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.common.DBCommand;
import com.book.product.service.ProductService;
import com.book.product.serviceImpl.ProductServiceImpl;
import com.book.product.vo.ProductVO;

public class ProductList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 전체상품 리스트
		
		ProductService service = new ProductServiceImpl();
		List<ProductVO> list = service.selectProductList();
		
		request.setAttribute("productList", list);
		
		
		return "admin/productList.tiles";
	}

}
