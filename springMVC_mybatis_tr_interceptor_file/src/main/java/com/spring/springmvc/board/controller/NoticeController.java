package com.spring.springmvc.board.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.springmvc.board.model.service.NoticeService;
import com.spring.springmvc.board.model.vo.Notice;
import com.spring.springmvc.member.model.vo.Member;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService ns;

	@RequestMapping("/notice/noticelist.do")
	public ModelAndView noticeList(@RequestParam Map<String, Object> commandMap) {

		ModelAndView mav = new ModelAndView();

		int currentPage = 1;
		int cntPerPage = 10;
		String orderby = "noticeno";

		if (commandMap.get("cPage") != null) {
			currentPage = Integer.parseInt((String) commandMap.get("cPage"));
		}

		if (commandMap.get("cntPerPage") != null) {
			cntPerPage = Integer.parseInt((String) commandMap.get("cPage"));
		}

		Map<String, Object> res = ns.selectNoticeList(orderby, currentPage, cntPerPage);
		mav.addObject("noticeData", res);
		mav.setViewName("board/boardList");

		return mav;
	}

	@RequestMapping("/notice/noticedetail.do")
	public ModelAndView noticeDetail(int noticeNo) {
		ModelAndView mav = new ModelAndView();
		
		
		return mav;
	}

	@RequestMapping("/notice/noticewrite.do")
	public String noticeWrite() {
		return "board/boardForm";
	}

	@RequestMapping("/notice/noticeupload.do")
	public ModelAndView noticeUpload(Notice notice, @RequestParam List<MultipartFile> files,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		String root = request.getSession().getServletContext().getRealPath("/");

		List<Map<String, Object>> fileData = new ArrayList<Map<String, Object>>();

		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("logInInfo");
		notice.setNoticeWriter(member.getM_id());

		for (MultipartFile mf : files) {
			String savePath = root + "resources/upload/";
			String originFileName = mf.getOriginalFilename();

			HashMap<String, Object> data = new HashMap<String, Object>();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

			String renameFileName = sdf.format(new Date()) + "."
					+ originFileName.substring(originFileName.lastIndexOf(".") + 1);

			savePath += renameFileName;
			
			data.put("originFileName", originFileName);
			data.put("renameFileName", renameFileName);
			data.put("savePath", savePath);
			data.put("file", mf);
			
			fileData.add(data);
			
		}
		
		int res = ns.insertNotice(notice, fileData);
		mav.setViewName("redirect:noticelist.do");
		return mav;

	}
	
	
	
	
	
	
	
	
	

}
