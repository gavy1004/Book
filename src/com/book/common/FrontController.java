package com.book.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.admin.web.AdminPage;
import com.book.admin.web.ProductInsert;
import com.book.admin.web.ProductInsertForm;
import com.book.admin.web.ProductList;
import com.book.member.web.MemberJoin;
import com.book.member.web.MemberJoinForm;
import com.book.member.web.MemberList;
import com.book.member.web.MemberLogOut;
import com.book.member.web.MemberLogin;
import com.book.member.web.MemberLoginForm;
import com.book.product.web.NovelList;
import com.book.product.web.NovelSelect;
import com.book.product.web.ProductDelete;
import com.book.product.web.ProductSelect;
import com.book.product.web.ProductUpdate;
import com.book.product.web.likeIt;

public class FrontController extends HttpServlet {
	
	private HashMap<String , DBCommand> map = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/index.do", new IndexPage());
		
		
		// 맴버관련
		map.put("/memberJoinForm.do", new MemberJoinForm());	//회원가입폼
		map.put("/memberJoin.do", new MemberJoin());			//회원가입
		map.put("/memberLoginForm.do", new MemberLoginForm());	//로그인폼
		map.put("/memberLogin.do", new MemberLogin());			//로그인
		map.put("/memberLogOut.do", new MemberLogOut());		//로그아웃
		map.put("/memberList.do", new MemberList());			//회원리스트
		
		//관리자
		map.put("/adminPage.do", new AdminPage());					//관리자페이지 
		map.put("/productInsertForm.do", new ProductInsertForm());	//상품입력폼
		map.put("/productInsert.do", new ProductInsert());			//상품입력
		map.put("/productList.do", new ProductList());				//상품리스트조회
		map.put("/productDelete.do", new ProductDelete());			//상품삭제
		map.put("/productUpdate.do", new ProductUpdate());			//상품업데이트
		map.put("/productSelect.do", new ProductSelect());			//상품한건조회
			
		// 상품
		map.put("/novelList.do", new NovelList());			//메인 리스트 조회
		map.put("/novelSelect.do", new NovelSelect()); 		//한건조회
		map.put("/likeIt.do", new likeIt());				//좋아요
		
		
		// 장바구니
		map.put("/cartInsert.do", new CartInsert());	// 장바구니담기
		map.put("/cartList.do", new CartList());		// 장바구니조회
		map.put("/cartDelete.do", new CartDelete());	// 장바구니삭제
		map.put("/cartUpdate.do", new CartUpdate());	// 장바구니수정
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String uri = req.getRequestURI();
		String cpath = req.getContextPath();
		String path = uri.substring(cpath.length());
		DBCommand Command = map.get(path);
		
		String viewPage = Command.execute(req, resp);
		
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
	}
}
