package com.spring.springmvc.book.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.springmvc.book.model.vo.Book;

@Repository
public class BookDao {
	
	@Autowired
	SqlSessionTemplate session;
	
	//검색
	public List<Book> selectBookList(String title){
		
		List<Book> res = new ArrayList<Book>();
		res = session.selectList("Book.selectBookList", title);
		return res;
		
	}
	
	//검색내 검색
	public List<Book> selectInnerBookSearchList(Map<String, Object> commandMap){
		List<Book> res = new ArrayList<Book>();
		res = session.selectList("Book.selectInnerBookSearchList", commandMap);
		return res;
	}
	
	//상세페이지
	public Book selectBook(int b_bno) { 	
		Book res = session.selectOne("Book.selectBook", b_bno);
		
		
		return res;
	};
	
}
