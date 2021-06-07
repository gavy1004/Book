package com.book.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.book.bulletin.web.BulletinList;
import com.book.member.service.MemberService;
import com.book.member.serviceImpl.MemberServiceImpl;
import com.book.member.vo.MemberVO;
import com.book.member.web.MemberList;

public class MemberSelect implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id =(String) session.getAttribute("id");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);

		MemberService service = new MemberServiceImpl();
		service.selectMember(vo);

		request.setAttribute("member", vo);
		return "member/memberUpdate.tiles";
	}

}
