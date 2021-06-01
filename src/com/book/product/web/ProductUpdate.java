package com.book.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.admin.web.ProductList;
import com.book.common.DBCommand;
import com.book.product.service.ProductService;
import com.book.product.serviceImpl.ProductServiceImpl;
import com.book.product.vo.ProductVO;

public class ProductUpdate implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String cat = request.getParameter("category");
		String code = request.getParameter("bookCode");
		String image = request.getParameter("bookImage");
		String name = request.getParameter("bookName");
		String contents = request.getParameter("contents");
		String price = request.getParameter("price");
		String sale = request.getParameter("sale");
		String sprice = request.getParameter("salePrice");
		String writer = request.getParameter("writer");
		
		ProductVO vo = new ProductVO();
		vo.setCategory(cat);
		vo.setBookCode(code);
		vo.setBookImage(image);
		vo.setBookName(name);
		vo.setContents(contents);
		vo.setLikeIt(0);
		vo.setPrice(price);
		vo.setSale(sale);
		vo.setSalePrice(sprice);
		vo.setWriter(writer);
		
		
		ProductService service = new ProductServiceImpl();
		service.updateProduct(vo);
		
		
		DBCommand command = new ProductList();
		command.execute(request, response);
		
		request.setAttribute("product", vo);
		
		return "admin/productList.tiles";
	}

}
