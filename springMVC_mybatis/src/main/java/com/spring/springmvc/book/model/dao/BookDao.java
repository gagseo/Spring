package com.spring.springmvc.book.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.springmvc.book.model.vo.Book;

@Repository
public class BookDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<Book> selectBookList(String title){
		
		return sqlSessionTemplate.selectOne("Book.selectBookList" , title);
		
	}
	
	public List<Book> selectInnerBookSearchList(Map<String, Object> commandMap){
		
		return sqlSessionTemplate.selectOne("Book.selectInnerBookSearchList", commandMap);
		
	}
	
	public Book selectBook(int b_bno) {
		
		return sqlSessionTemplate.selectOne("Book.selectBook", b_bno);
	}
	
	
	
	
}
