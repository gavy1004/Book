package com.book.admin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.common.DBCommand;
import com.book.common.Paging;
import com.book.notice.serviceImpl.NoticeServiceImpl;
import com.book.notice.vo.NoticeVO;
import com.book.product.service.ProductService;
import com.book.product.serviceImpl.ProductServiceImpl;
import com.book.product.vo.ProductVO;

public class ProductList implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 전체상품 리스트
		String page = request.getParameter("page"); // 페이지번호

		if (page == null)
			page = "1";

		int pageCnt = Integer.parseInt(page);

		ProductServiceImpl service = new ProductServiceImpl();
		List<ProductVO> total = service.selectProductList(); // 전체 카운트

		service = new ProductServiceImpl();
		List<ProductVO> list = service.memberListPaging(pageCnt);

		Paging paging = new Paging();
		paging.setPageNo(pageCnt);
		paging.setPageSize(10);
		paging.setTotalCount(total.size());

		request.setAttribute("paging", paging);
		request.setAttribute("productList", list);
		return "admin/productList.tiles";
	}

}
