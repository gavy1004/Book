package com.book.bulletin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.admin.web.ProductList;
import com.book.bulletin.service.BulletinService;
import com.book.bulletin.serviceImpl.BulletinServiceImpl;
import com.book.bulletin.vo.BulletinVO;
import com.book.common.DBCommand;


public class BulletinInsert implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String writer = (String) session.getAttribute("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String bookCode = request.getParameter("bookCode");

		System.out.println(bookCode);
		
		BulletinVO vo = new BulletinVO();
		vo.setContent(content);
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setBookCode(bookCode);
		
		BulletinService service = new BulletinServiceImpl();
		service.insertBulletin(vo);

		request.setAttribute("bulletin", vo);
		
		BulletinList commad = new BulletinList();				//변경된 리스트 
		commad.execute(request, response);
		
		return "bulletin/bulletinList.tiles";
	}

}
