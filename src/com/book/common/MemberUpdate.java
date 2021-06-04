package com.book.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberUpdate implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		
		return "member/memberUpdate.tiles";
	}

}
