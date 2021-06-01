package com.book.product.vo;

public class ProductVO {
	private String bookCode;
	private String bookName;
	private String bookImage;
	private String contents;
	private String price;
	private String salePrice;
	private String sale;
	private String writer;
	private int likeIt;
	private String Category;
		
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public int getLikeIt() {
		return likeIt;
	}
	public void setLikeIt(int likeIt) {
		this.likeIt = likeIt;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookImage() {
		return bookImage;
	}
	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	public String getSale() {
		return sale;
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "ProductVO [bookCode=" + bookCode + ", bookName=" + bookName + ", bookImage=" + bookImage + ", contents="
				+ contents + ", price=" + price + ", salePrice=" + salePrice + ", sale=" + sale + ", writer=" + writer
				+ ", likeIt=" + likeIt + ", Category=" + Category + "]";
	}
	
	
	
}
