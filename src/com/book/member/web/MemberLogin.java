package com.book.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.common.DBCommand;
import com.book.member.serviceImpl.MemberServiceImpl;
import com.book.member.vo.MemberVO;

public class MemberLogin implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String id = request.getParameter("memberId"); 
		String pwd = request.getParameter("memberPwd"); 
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(pwd);
		
		MemberServiceImpl service = new MemberServiceImpl();
		MemberVO rvo = service.loginCheck(vo);
		String path="";
		
		if(rvo == null) { 
			
			path = "member/memberLoginFail.tiles";
		}else {
			session.setAttribute("id", rvo.getId());
			request.setAttribute("vo", rvo);
			
			path = "member/memberLoginSuccess.tiles";
		}
		
		return path;
	}

}
