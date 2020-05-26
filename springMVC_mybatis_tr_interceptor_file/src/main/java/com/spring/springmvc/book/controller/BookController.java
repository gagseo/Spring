package com.spring.springmvc.book.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.springmvc.book.model.service.BookService;
import com.spring.springmvc.book.model.vo.Book;

@Controller
public class BookController {
	
	@Autowired
	BookService bs;
	
	@RequestMapping("/book/search.do")
	public ModelAndView selectBookList(String b_title) {
		ModelAndView mav = new ModelAndView();
		List<Book> res = bs.selectBookList(b_title);
		mav.addObject("booklist", res);
		mav.setViewName("book/booksearch");
		
		return mav;
	}
	
	@RequestMapping("/book/innersearch.do")
	public ModelAndView selectInnerBookSearchList(@RequestParam Map<String,Object> commandMap,String[] bnoList) { 	
												
	
		// 
		
		ModelAndView mav = new ModelAndView();
		
//		String[] bnolist = request.getParameterValues("bnoList");
//		
//		String title = request.getParameter("title");
//		String orderBy = request.getParameter("orderBy");
//		
//		Map<String, Object> commandMap = new HashMap<String, Object>();
		
		commandMap.put("bnoList",bnoList);
//		commandMap.put("title",title);
//		commandMap.put("orderBy",orderBy);
		
		List<Book> res = bs.selectInnerBookSearchList(commandMap);
		mav.addObject("booklist", res);
		mav.setViewName("book/booksearch");
		
		return mav;
	}
	
	
	// 도서 상세검색
	@RequestMapping("/book/detail.do")
	public ModelAndView selectBook(int b_bno) {
		ModelAndView mav = new ModelAndView();
		//System.out.println("컨트롤러 " + b_bno);
		Book res = bs.selectBook(b_bno);
		mav.addObject("book", res);
		mav.setViewName("book/bookDetail");
		
		
		return mav;
	}
	

}
