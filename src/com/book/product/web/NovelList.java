package com.book.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.common.DBCommand;
import com.book.product.service.ProductService;
import com.book.product.serviceImpl.ProductServiceImpl;
import com.book.product.vo.ProductVO;

public class NovelList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		int cartCnt = (int) session.getAttribute("cartCnt");
		
		ProductService service = new ProductServiceImpl();
		List<ProductVO> list = service.selectProductList();	// 전체 조회
		List<ProductVO> nlist = service.selectNovelList();	// 소설 조회
		List<ProductVO> plist = service.selectPoemList();	// 시 조회
		
		
		request.setAttribute("list", list);
		request.setAttribute("nlist", nlist);
		request.setAttribute("plist", plist);
		
		session.setAttribute("cartCnt",cartCnt);
		session.setAttribute("id", id);
		
		return "layout/section.tiles";
	}

}
