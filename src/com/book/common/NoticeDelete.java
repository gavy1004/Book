package com.book.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.notice.service.NoticeService;
import com.book.notice.serviceImpl.NoticeServiceImpl;
import com.book.notice.vo.NoticeVO;

public class NoticeDelete implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		NoticeVO vo = new NoticeVO();
		vo.setId(Integer.parseInt(id));
		System.out.println(id);
		NoticeService service = new NoticeServiceImpl();
		service.deleteNotice(vo);
		
		return "/noticeList.do";
	}

}
