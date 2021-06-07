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
import com.book.bulletin.web.BulletinDelete;
import com.book.bulletin.web.BulletinForm;
import com.book.bulletin.web.BulletinInsert;
import com.book.bulletin.web.BulletinList;
import com.book.bulletin.web.BulletinSelect;
import com.book.bulletin.web.BulletinUpdate;
import com.book.bulletin.web.ReviewSelect;
import com.book.cart.web.CartAllDelete;
import com.book.cart.web.CartDelete;
import com.book.cart.web.CartInsert;
import com.book.cart.web.CartList;
import com.book.cart.web.CartOrderForm;
import com.book.cart.web.CartUpdate;
import com.book.member.web.MemberJoin;
import com.book.member.web.MemberJoinForm;
import com.book.member.web.MemberList;
import com.book.member.web.MemberLogOut;
import com.book.member.web.MemberLogin;
import com.book.member.web.MemberLoginForm;
import com.book.notice.web.NoticeDelete;
import com.book.notice.web.NoticeForm;
import com.book.notice.web.NoticeInsert;
import com.book.notice.web.NoticeList;
import com.book.notice.web.NoticeListPaging;
import com.book.notice.web.NoticeSelect;
import com.book.notice.web.NoticeUpdate;
import com.book.order.web.OrderInsert;
import com.book.order.web.OrderList;
import com.book.order.web.OrderSelect;
import com.book.product.web.BestSellerList;
import com.book.product.web.BestSellsrList;
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
		map.put("/memberUpdate.do", new MemberUpdate());
		map.put("/memberSelect.do", new MemberSelect());
		
		//관리자
		map.put("/adminPage.do", new AdminPage());					//관리자페이지 
		map.put("/productInsertForm.do", new ProductInsertForm());	//상품입력폼
		map.put("/productInsert.do", new ProductInsert());			//상품입력
		map.put("/productList.do", new ProductList());				//상품리스트조회
		map.put("/productDelete.do", new ProductDelete());			//상품삭제
		map.put("/productUpdate.do", new ProductUpdate());			//상품업데이트
		map.put("/productSelect.do", new ProductSelect());			//상품한건조회
		map.put("/productSearch.do", new ProductSearch());
		
		// 상품
		map.put("/novelList.do", new NovelList());			// 메인리스트 조회
		map.put("/novelSelect.do", new NovelSelect()); 		// 한건조회
		map.put("/likeIt.do", new likeIt());				// 좋아요
		map.put("/bestSeller.do", new BestSellsrList());	// 베스트셀러조회
		
		// 장바구니
		map.put("/cartInsert.do", new CartInsert());		// 장바구니담기
		map.put("/cartList.do", new CartList());			// 장바구니조회
		map.put("/cartDelete.do", new CartDelete());		// 장바구니삭제
		map.put("/cartAllDelete.do", new CartAllDelete());	// 장바구니전체삭제(사용안함)
		map.put("/cartUpdate.do", new CartUpdate());		// 장바구니수정
		map.put("/cartOrder.do", new CartOrderForm());		// 결제페이지
		
		// 주문
		map.put("/orderInsert.do", new OrderInsert());		//주문정보입력
		map.put("/orderList.do", new OrderList());			//주문내역리스트
		map.put("/orderSelect.do", new OrderSelect());		//주문내역한건조회
		map.put("/orderListAll.do", new OrderListAll());	//전체주문내역
		
		// 공지사항 게시판
		map.put("/noticeList.do", new NoticeList());			//공지사항리스트
		map.put("/noticeListPaging.do", new NoticeListPaging());
		map.put("/noticeSelect.do", new NoticeSelect());		//공지사항선택
		map.put("/noticeDelete.do", new NoticeDelete());		//공지사항삭제
		map.put("/noticeUpdate.do", new NoticeUpdate());		//공지사항수정
		map.put("/noticeForm.do", new NoticeForm());			//공지사항입력폼
		map.put("/noticeInsert.do", new NoticeInsert());		//공지사항입력
		
		// 구매후기 게시판
		map.put("/bulletinForm.do", new BulletinForm());		//후기게시판 폼
		map.put("/bulletinList.do", new BulletinList());		//후기게시판 리스트
		map.put("/bulletinSelect.do", new BulletinSelect());	//후기게시판 선택
		map.put("/bulletinUpdate.do", new BulletinUpdate());	//후기게시판 수정
		map.put("/bulletinDelte.do", new BulletinDelete()); 	//후기게시판 삭제
		map.put("/bulletinInsert.do", new BulletinInsert());
		map.put("/reviewSelect.do", new ReviewSelect());
		
		// 카테고리
		map.put("/bestSeller.do", new BestSellerList());		//베스트셀러메뉴
		map.put("/novelMenu.do", new NovelMenuList());			//소설메뉴
		map.put("/poemMenu.do", new PoemMenuList());			//시메뉴
		
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
