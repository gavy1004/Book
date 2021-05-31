package com.book.cart.vo;

public class CartVO {
	private String userId;
	private String bookCode;
	private String bookName;
	private String bookQty;
	private String price;
	private String sale;
	private String salePrice;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getBookQty() {
		return bookQty;
	}
	public void setBookQty(String bookQty) {
		this.bookQty = bookQty;
	}
	
	
}
