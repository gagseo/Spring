package com.spring.springmvc.book.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.springmvc.book.model.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bs;

	@RequestMapping("/book/search.do")
	public ModelAndView searchBookList(String b_title) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("booklist", bs.selectBookList(b_title));
		mav.setViewName("book/booksearch");

		return mav;

	}

	@RequestMapping("/book/innersearch.do")
	public ModelAndView innerSearch(String title) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("booklist", bs.selectInnerBookSearchList(title));
		mav.setViewName("book/booksearch");

		return mav;

	}

	@RequestMapping("/book/detail.do")
	public ModelAndView detail(int b_bno) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", bs.selectBook(b_bno));

		return mav;

	}
}
