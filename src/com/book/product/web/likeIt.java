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
		// 메인 화면에서 좋아요 추가 하는 경우 
		String bookCode = request.getParameter("bookCode");

		ProductVO vo = new ProductVO();
		vo.setBookCode(bookCode);
		 
		ProductService service = new ProductServiceImpl();
		service.insertLikeIt(vo);
		return "/novelList.do";
	}

}
