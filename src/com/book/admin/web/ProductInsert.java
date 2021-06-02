package com.book.admin.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.common.DBCommand;
import com.book.product.service.ProductService;
import com.book.product.serviceImpl.ProductServiceImpl;
import com.book.product.vo.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductInsert implements DBCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String path = "c:/tmp";

		ServletContext sc = request.getServletContext();
		path = sc.getRealPath("upload"); // 서버상 경로

		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, // 요청정보
					path, // 파일위치
					8 * 1024 * 1024, // 파일용량
					"UTF-8", // 인코딩
					new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}

		Enumeration en = multi.getFileNames();
		String category = multi.getParameter("category");
		String code = multi.getParameter("bookCode");
		String name = multi.getParameter("bookName");
		String image = multi.getParameter("bookImage");
		String content = multi.getParameter("contents");
		String price = multi.getParameter("price");
		String sprice = multi.getParameter("salePrice");
		String sale = multi.getParameter("sale");
		String writer = multi.getParameter("writer");
		String like = multi.getParameter("likeIt");

		String fileN = "";

		while (en.hasMoreElements()) {
			String fname = (String) en.nextElement();
			String fileName = multi.getFilesystemName(fname);
			fileN = fileName;
			System.out.println("name: " + name + ", fileName: " + fileName);
		}

		HttpSession session = request.getSession();

		ProductVO vo = new ProductVO();
		vo.setBookCode(code);
		vo.setBookName(name);
		vo.setBookImage(fileN);
		vo.setContents(content);
		vo.setPrice(price);
		vo.setSale(sale);
		vo.setSalePrice(sprice);
		vo.setWriter(writer);
		vo.setCategory(category);
		vo.setLikeIt(0);
		System.out.println(vo);
		
		ProductService service = new ProductServiceImpl();
		service.insertProduct(vo);

		DBCommand command = new ProductList();
		command.execute(request, response);

		
		session.setAttribute("product", vo);

		return "admin/productList.tiles";

	}

}
