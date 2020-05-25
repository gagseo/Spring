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
	public List<Book> selectBookList(String b_title) {
		return bDao.selectBookList(b_title);
	}

	@Override
	public List<Book> selectInnerBookSearchList(String title) {
		return bDao.selectInnerBookSearchList(title);
	}

	@Override
	public Book selectBook(int b_bno) {
		return bDao.selectBook(b_bno);
	}

}
