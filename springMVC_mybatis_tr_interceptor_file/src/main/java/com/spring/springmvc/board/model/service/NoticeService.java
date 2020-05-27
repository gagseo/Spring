package com.spring.springmvc.board.model.service;

import java.util.List;
import java.util.Map;

import com.spring.springmvc.board.model.vo.Notice;

public interface NoticeService {

	public Map<String, Object> selectNoticeList(String orderby, int currentPage, int cntPerPage);

	public Map<String, Object> noticeDetail(int noticeNo);

	public int insertNotice(Notice n, List<Map<String, Object>> fileData);

	// 파일업로드
	public int insertFile(List<Map<String, Object>> fileData);

	// 게시물삭제
	public int deleteNotice(int noticeNo);

	// 파일삭제
	public void deleteFile(int noticeNo);

}
