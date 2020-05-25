package com.spring.springmvc.book.model.service;

import java.util.List;
import java.util.Map;

import com.spring.springmvc.book.model.vo.Book;

public interface BookService {
	
	public List<Book> selectBookList(String title);
	public List<Book> selectInnerBookSearchList(String title);
	public Book selectBook(int b_bno);
	
}
