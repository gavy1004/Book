package com.book.bulletin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.bulletin.service.BulletinService;
import com.book.bulletin.serviceImpl.BulletinServiceImpl;
import com.book.bulletin.vo.BulletinVO;
import com.book.common.DBCommand;

public class ReviewSelect implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String bookCode = request.getParameter("bookCode");
		
		BulletinVO vo = new BulletinVO();
		vo.setBookCode(bookCode);
		
		BulletinService service = new BulletinServiceImpl();
		List<BulletinVO> list = service.reviewSelect(vo);
		
		request.setAttribute("bulletin", list);
		return "bulletin/reviewSelect.tiles";
	}

}
