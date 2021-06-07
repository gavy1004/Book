package com.book.cart.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.common.DBCommand;
import com.book.member.serviceImpl.MemberServiceImpl;
import com.book.member.vo.MemberVO;

public class CartOrderForm implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		
		MemberServiceImpl service = new MemberServiceImpl();
		service.selectMember(vo);
		
		request.setAttribute("member", vo);
		return "cart/cartOrder.tiles";
	}

}
