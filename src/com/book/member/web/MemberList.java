package com.book.member.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.common.DBCommand;
import com.book.member.serviceImpl.MemberServiceImpl;
import com.book.member.vo.MemberVO;
import com.book.common.Paging;

public class MemberList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = request.getParameter("page");	//페이지번호
		if(page ==null)
			page="1";
		int pageCnt = Integer.parseInt(page);
		
		MemberServiceImpl service = new MemberServiceImpl();
		List<MemberVO> total = service.selectMemberList();		//전체 카운트
		
		service = new MemberServiceImpl();
		List<MemberVO> list = service.bulletinListPaging(pageCnt);
		
		Paging paging = new Paging();
	    paging.setPageNo(pageCnt);
	    paging.setPageSize(10);
	    paging.setTotalCount(total.size());

	    request.setAttribute("paging", paging);
	    request.setAttribute("bulletinList", list);
		
		return "member/memberListPaging.tiles";
	}

}
