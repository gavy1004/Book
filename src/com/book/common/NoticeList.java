package com.book.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.notice.service.NoticeService;
import com.book.notice.serviceImpl.NoticeserviceImpl;
import com.book.notice.vo.NoticeVO;

public class NoticeList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		NoticeService service = new NoticeserviceImpl();
		List<NoticeVO> list =  service.selectNoticeList();
		
		request.setAttribute("noticeList", list);
		
		return "notice/noticeList.tiles";
	}

}
