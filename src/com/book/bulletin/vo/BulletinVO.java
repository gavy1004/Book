package com.book.bulletin.vo;

import java.util.Date;

public class BulletinVO {
	private String id;
	private String title;
	private String content;
	private Date date;
	private String bookCode;
	private int hit;
	private String likeIt;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getLikeIt() {
		return likeIt;
	}
	public void setLikeIt(String likeIt) {
		this.likeIt = likeIt;
	}
	
	
	
}
