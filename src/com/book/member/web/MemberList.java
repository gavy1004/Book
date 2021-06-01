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

		
		MemberServiceImpl service = new MemberServiceImpl();
		List<MemberVO> list  = service.selectMemberList();		//전체 카운트
		
	    request.setAttribute("memberList", list);
		
		return "member/memberListPaging.tiles";
	}

}
