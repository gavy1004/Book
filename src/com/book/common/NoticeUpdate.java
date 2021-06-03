package com.book.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.notice.service.NoticeService;
import com.book.notice.serviceImpl.NoticeserviceImpl;
import com.book.notice.vo.NoticeVO;

public class NoticeUpdate implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String contents = request.getParameter("content");
		String id = request.getParameter("id");

		NoticeVO vo = new NoticeVO();
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setId(Integer.parseInt(id));
		
		NoticeService service = new NoticeserviceImpl();
		service.updateNotice(vo);
		
		return "noticeList.do";
	}

}
