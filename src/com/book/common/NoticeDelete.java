package com.book.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.notice.service.NoticeService;
import com.book.notice.serviceImpl.NoticeserviceImpl;
import com.book.notice.vo.NoticeVO;

public class NoticeDelete implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		NoticeVO vo = new NoticeVO();
		vo.setId(id);
		
		NoticeService service = new NoticeserviceImpl();
		service.deleteNotice(vo);
		
		return "noticelist.do";
	}

}
