package com.spring.springmvc.book.controller;

import java.util.List;
import java.util.Map;

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
	public ModelAndView searchBookList() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("book/booksearch");

		return mav;

	}

	@RequestMapping("/book/innersearch.do")
	public ModelAndView innerSearch(@RequestParam Map<String, Object> commandMap) {
		ModelAndView mav = new ModelAndView();
		List<Book> res = bs.selectInnerBookSearchList(commandMap);
		mav.addObject("booklist", res);
		mav.setViewName("book/booksearch");

		return mav;

	}

	@RequestMapping("/book/detail.do")
	public ModelAndView detail(int b_bno) {
		ModelAndView mav = new ModelAndView();

		Book b = new Book();
		mav.addObject("book", b);

		return mav;

	}
}
