package com.book.bulletin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.bulletin.service.BulletinService;
import com.book.bulletin.serviceImpl.BulletinServiceImpl;
import com.book.bulletin.vo.BulletinVO;
import com.book.common.DBCommand;

public class BulletinList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BulletinService service = new BulletinServiceImpl();
		List<BulletinVO> list = service.bulletinSelectList();
		
		request.setAttribute("bulletinList", list);
		
		
		return "bulletin/bulletinList.tiles";
	}

}
