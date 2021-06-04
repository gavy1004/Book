package com.book.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.product.service.ProductService;
import com.book.product.serviceImpl.ProductServiceImpl;
import com.book.product.vo.ProductVO;

public class BestSellsrList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ProductService service = new ProductServiceImpl();
		List<ProductVO> blist = service.selectBestList();	
		
		request.setAttribute("blist", blist);
		return null;
	}

}
