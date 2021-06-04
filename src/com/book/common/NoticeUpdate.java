package com.book.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.notice.service.NoticeService;
import com.book.notice.serviceImpl.NoticeServiceImpl;
import com.book.notice.vo.NoticeVO;

public class NoticeUpdate implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String contents = request.getParameter("content");
		String id = request.getParameter("id");
		System.out.println(title);
		System.out.println(contents);
		System.out.println(id);
		NoticeVO vo = new NoticeVO();
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setId(Integer.parseInt(id));
		
		NoticeService service = new NoticeServiceImpl();
		service.updateNotice(vo);
		
		return "/noticeListPaging.do";
	}

}
