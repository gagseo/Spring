package com.spring.springmvc.book.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springmvc.book.model.dao.BookDao;
import com.spring.springmvc.book.model.vo.Book;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookDao bd;

	@Override
	public List<Book> selectBookList(String title) {
		
		return bd.selectBookList(title);
	}

	@Override
	public List<Book> selectInnerBookSearchList(Map<String, Object> commandMap) {
		return bd.selectInnerBookSearchList(commandMap);
	}

	@Override
	public Book selectBook(int b_bno) {
		return bd.selectBook(b_bno);
	}

}
