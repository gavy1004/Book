package com.book.bulletin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.bulletin.service.BulletinService;
import com.book.bulletin.serviceImpl.BulletinServiceImpl;
import com.book.bulletin.vo.BulletinVO;
import com.book.common.DBCommand;

public class BulletinUpdate implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BulletinVO vo = new BulletinVO();
		vo.setId(id);
		vo.setTitle(title);
		vo.setContent(content);
		
		BulletinService service = new BulletinServiceImpl();
		service.updateBulletin(vo);
		
		DBCommand command = new BulletinList();
		String path = command.execute(request, response);
		
		request.setAttribute("bulletin", vo);
		
		return "bulletin/bulletinList.tiles";
	}
}
