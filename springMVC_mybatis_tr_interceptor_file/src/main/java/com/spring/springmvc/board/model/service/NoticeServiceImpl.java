package com.spring.springmvc.board.model.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.springmvc.board.model.dao.NoticeDao;
import com.spring.springmvc.board.model.vo.Notice;

import common.util.Paging;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao nd;

	@Override
	public Map<String, Object> selectNoticeList(String orderby, int currentPage, int cntPerPage) {

		Map<String, Object> res = new HashMap<String, Object>();
		Paging page = new Paging(nd.contentCnt(), currentPage, cntPerPage);

		List<Notice> nlist = nd.selectNoticList(page, orderby);
		res.put("paging", page);
		res.put("nlist", nlist);

		return res;
	}

	@Override
	public Map<String, Object> noticeDetail(int noticeNo) {
		
		
		
		return null;
	}

	@Override
	public int insertNotice(Notice n, List<Map<String, Object>> fileData) {

		int result = nd.insertNotice(n);
		insertFile(fileData);
		return result;
	}

	@Override
	public int insertFile(List<Map<String, Object>> fileData) {

		int res = 0;
		
		for (Map<String, Object> file : fileData) {
			
			nd.insertFile(file);
			
			MultipartFile mf = (MultipartFile) file.get("file");

			File f = new File((String) file.get("savePath"));

			try {
				mf.transferTo(f);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;

	}

}
