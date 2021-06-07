package com.book.bulletin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.bulletin.service.BulletinService;
import com.book.bulletin.serviceImpl.BulletinServiceImpl;
import com.book.bulletin.vo.BulletinVO;
import com.book.common.DBCommand;
import com.book.common.Paging;

public class BulletinList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");	// 페이지번호
		
		if(page == null) 
			page= "1";
		
		int pageCnt = Integer.parseInt(page);

		BulletinServiceImpl service = new BulletinServiceImpl();
		List<BulletinVO> total =  service.bulletinSelectList();	//	 전체 카운트
		
		service = new BulletinServiceImpl();
		List<BulletinVO> list = service.bulltinListPaging(pageCnt);
		
        Paging paging = new Paging();
        paging.setPageNo(pageCnt);
        paging.setPageSize(10);
        paging.setTotalCount(total.size());

        request.setAttribute("paging", paging);
		request.setAttribute("bulletinList", list);
		
		
		return "bulletin/bulletinList.tiles";
	}

}
