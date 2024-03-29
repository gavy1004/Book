package com.book.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.common.DBCommand;
import com.book.notice.service.NoticeService;
import com.book.notice.serviceImpl.NoticeServiceImpl;
import com.book.notice.vo.NoticeVO;


public class NoticeSelect implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id =request.getParameter("id");

		if(id== null)
			id="0";
		
		NoticeVO vo = new NoticeVO();
		vo.setId(Integer.parseInt(id));
		
		NoticeService service = new NoticeServiceImpl();
		service.selectNotice(vo);
		
		request.setAttribute("notice", vo);
		return "notice/notice.tiles";
	}

}
