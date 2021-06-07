package com.book.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.bulletin.web.BulletinList;
import com.book.common.DBCommand;
import com.book.member.service.MemberService;
import com.book.member.serviceImpl.MemberServiceImpl;
import com.book.member.vo.MemberVO;

public class MemberUpdate implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
	
		MemberVO vo = new MemberVO();
		vo.setEmail(email);
		vo.setId(id);
		vo.setName(name);
		vo.setPhone(phone);
		
		MemberService service = new MemberServiceImpl();
		service.updateMember(vo);
		DBCommand command = new BulletinList();
		String path = command.execute(request, response);
		request.setAttribute("member", vo);
		
		return "member/memberUpdate.tiles";
	}

}
