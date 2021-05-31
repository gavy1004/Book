package com.book.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.common.DBCommand;
import com.book.member.service.MemberService;
import com.book.member.serviceImpl.MemberServiceImpl;
import com.book.member.vo.MemberVO;

public class MemberJoin implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String id = request.getParameter("memberId");
		String pwd = request.getParameter("memberPwd");
		String name = request.getParameter("memberName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(pwd);
		vo.setName(name);
		vo.setPhone(phone);
		vo.setEmail(email);
		
		MemberService service = new MemberServiceImpl();
		service.insertMember(vo);
		
		session.setAttribute("id", id);
		session.setAttribute("member", vo);
		return "main/main.tiles";
	}

}
