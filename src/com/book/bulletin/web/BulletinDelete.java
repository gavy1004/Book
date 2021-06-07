package com.book.bulletin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.bulletin.service.BulletinService;
import com.book.bulletin.serviceImpl.BulletinServiceImpl;
import com.book.bulletin.vo.BulletinVO;
import com.book.common.DBCommand;
import com.book.notice.service.NoticeService;
import com.book.notice.serviceImpl.NoticeServiceImpl;
import com.book.notice.vo.NoticeVO;

public class BulletinDelete implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		BulletinVO vo = new BulletinVO();
		vo.setId(id);

		BulletinService service = new BulletinServiceImpl();
		service.deleteBulletin(vo);
		return "/bulletinList.do";
	}

}
