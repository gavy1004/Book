package com.book.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.book.bulletin.service.BulletinService;
import com.book.bulletin.serviceImpl.BulletinServiceImpl;
import com.book.bulletin.vo.BulletinVO;
import com.book.common.DBCommand;
import com.book.product.service.ProductService;
import com.book.product.serviceImpl.ProductServiceImpl;
import com.book.product.vo.ProductVO;

public class NovelSelect implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {		
		String bookcode = request.getParameter("bookCode");
		
		ProductVO vo =new ProductVO();
		vo.setBookCode(bookcode); 
		
		BulletinVO bvo= new BulletinVO();
		bvo.setBookCode(bookcode);
		
		ProductService service = new ProductServiceImpl();
		service.selectProduct(vo);
		
		BulletinService service1 = new BulletinServiceImpl();
		List<BulletinVO> list = service1.reviewSelect(bvo);
	
		request.setAttribute("bulletinList", list);
		request.setAttribute("book", vo);
		return "product/novelSelect2.tiles";
	}
}
