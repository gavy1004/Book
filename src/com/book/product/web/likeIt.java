package com.book.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.Request;

import com.book.common.DBCommand;
import com.book.product.service.ProductService;
import com.book.product.serviceImpl.ProductServiceImpl;
import com.book.product.vo.ProductVO;


public class likeIt implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String bookCode = request.getParameter("bookCode");
		System.out.println(bookCode);
		
		ProductVO vo = new ProductVO();
		vo.setBookCode(bookCode);
		 
		ProductService service = new ProductServiceImpl();
		service.insertLikeIt(vo);
		
		return "/novelList.do";
	}

}
