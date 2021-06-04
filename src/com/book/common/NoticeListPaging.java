package com.book.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.notice.service.NoticeService;
import com.book.notice.serviceImpl.NoticeServiceImpl;
import com.book.notice.vo.NoticeVO;


public class NoticeListPaging implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");	// 페이지번호
		if(page == null) 
			page= "1";
		
		int pageCnt = Integer.parseInt(page);
		
		NoticeServiceImpl service = new NoticeServiceImpl();
		List<NoticeVO> total =  service.selectNoticeList();	//	 전체 카운트
		
		service = new NoticeServiceImpl();
		List<NoticeVO> list = service.noticeListPaging(pageCnt);
		
		
        Paging paging = new Paging();
        paging.setPageNo(pageCnt);
        paging.setPageSize(10);
        paging.setTotalCount(total.size());

        request.setAttribute("paging", paging);
        request.setAttribute("noticeList", list);
        
		return "notice/noticeList.tiles";

	}

}
