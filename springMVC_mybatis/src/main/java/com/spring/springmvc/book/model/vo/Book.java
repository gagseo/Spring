package com.spring.springmvc.book.model.vo;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{

	private static final long serialVersionUID = 8932268572844084635L;
	
	private int b_bno;
	private int b_category;
	private String b_title;
	private String b_author;
	private Date b_regdate;
	private String b_rent_yn;
	private int b_rent_cnt;
	private int b_isbn;

	public Book() {
		
	}

	public Book(int b_bno, int b_category, String b_title, String b_author, Date b_regdate, String b_rent_yn,
			int b_rent_cnt, int b_isbn) {
		super();
		this.b_bno = b_bno;
		this.b_category = b_category;
		this.b_title = b_title;
		this.b_author = b_author;
		this.b_regdate = b_regdate;
		this.b_rent_yn = b_rent_yn;
		this.b_rent_cnt = b_rent_cnt;
		this.b_isbn = b_isbn;
	}

	public int getB_bno() {
		return b_bno;
	}

	public void setB_bno(int b_bno) {
		this.b_bno = b_bno;
	}

	public int getB_category() {
		return b_category;
	}

	public void setB_category(int b_category) {
		this.b_category = b_category;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_author() {
		return b_author;
	}

	public void setB_author(String b_author) {
		this.b_author = b_author;
	}

	public Date getB_regdate() {
		return b_regdate;
	}

	public void setB_regdate(Date b_regdate) {
		this.b_regdate = b_regdate;
	}

	public String getB_rent_yn() {
		return b_rent_yn;
	}

	public void setB_rent_yn(String b_rent_yn) {
		this.b_rent_yn = b_rent_yn;
	}

	public int getB_rent_cnt() {
		return b_rent_cnt;
	}

	public void setB_rent_cnt(int b_rent_cnt) {
		this.b_rent_cnt = b_rent_cnt;
	}

	public int getB_isbn() {
		return b_isbn;
	}

	public void setB_isbn(int b_isbn) {
		this.b_isbn = b_isbn;
	}

	@Override
	public String toString() {
		return "Book [b_bno=" + b_bno + ", b_category=" + b_category + ", b_title=" + b_title + ", b_author=" + b_author
				+ ", b_regdate=" + b_regdate + ", b_rent_yn=" + b_rent_yn + ", b_rent_cnt=" + b_rent_cnt + ", b_isbn="
				+ b_isbn + "]";
	}

	
}
