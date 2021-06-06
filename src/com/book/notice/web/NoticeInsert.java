package com.book.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.common.DBCommand;
import com.book.notice.service.NoticeService;
import com.book.notice.serviceImpl.NoticeServiceImpl;

import com.book.notice.vo.NoticeVO;

public class NoticeInsert implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		NoticeVO vo = new NoticeVO();
		vo.setTitle(title);
		vo.setContents(content);

		NoticeService service = new NoticeServiceImpl();
		service.insertNotice(vo);
		service.selectNoticeList();

		request.setAttribute("notice", vo);
		return "/noticeListPaging.do";
	}

}
