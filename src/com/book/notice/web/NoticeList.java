package com.book.notice.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.common.DBCommand;
import com.book.notice.service.NoticeService;
import com.book.notice.serviceImpl.NoticeServiceImpl;
import com.book.notice.vo.NoticeVO;

public class NoticeList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		NoticeService service = new NoticeServiceImpl();
		List<NoticeVO> list =  service.selectNoticeList();
		
		request.setAttribute("noticeList", list);
		
		return "notice/noticeList.tiles";
	}

}
