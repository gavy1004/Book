package com.book.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.member.service.MemberService;
import com.book.member.serviceImpl.MemberServiceImpl;
import com.book.member.vo.MemberVO;
import com.book.member.web.MemberList;

public class MemberUpdate implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("phone");
		String phone = request.getParameter("phone");
		
		MemberVO vo = new MemberVO();
		vo.setEmail(email);
		vo.setId(id);
		vo.setName(name);
		vo.setPhone(phone);
		
		MemberService service = new MemberServiceImpl();
		service.updateMember(vo);
		
		request.setAttribute("member", vo);
		
		return "member/memberUpdate.tiles";
	}

}
