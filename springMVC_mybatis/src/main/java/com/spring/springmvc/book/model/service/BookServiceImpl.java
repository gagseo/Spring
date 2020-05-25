package com.spring.springmvc.book.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springmvc.book.model.dao.BookDao;
import com.spring.springmvc.book.model.vo.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bDao;

	@Override
	public List<Book> selectBookList(String title) {
		return null;
	}

	@Override
	public List<Book> selectInnerBookSearchList(Map<String, Object> commandMap) {
		return null;
	}

	@Override
	public Book selectBook(int b_bno) {
		return null;
	}

}
