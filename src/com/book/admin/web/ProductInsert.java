package com.book.admin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.common.DBCommand;
import com.book.product.service.ProductService;
import com.book.product.serviceImpl.ProductServiceImpl;
import com.book.product.vo.ProductVO;

public class ProductInsert implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String category = request.getParameter("category");
		String code = request.getParameter("bookCode");
		String name = request.getParameter("bookName");
		String image = request.getParameter("bookImage");
		String content = request.getParameter("contents");
		String price = request.getParameter("price");
		String sprice = request.getParameter("salePrice");
		String sale = request.getParameter("sale");
		String writer = request.getParameter("writer");
		
		ProductVO vo = new ProductVO();
		vo.setBookCode(code);
		vo.setBookName(name);
		vo.setBookImage(image);
		vo.setContents(content);
		vo.setPrice(price);
		vo.setSale(sale);
		vo.setSalePrice(sprice);
		vo.setWriter(writer);
		vo.setCategory(category);
		
		ProductService service = new ProductServiceImpl();
		service.insertProduct(vo);
		
		DBCommand command = new ProductList();
		command.execute(request, response);
		
		session.setAttribute("category", category);
		session.setAttribute("product", vo);
				
		return "admin/productList.tiles";
		
	}

}
