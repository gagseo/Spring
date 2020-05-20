package com.spring.springmvc.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springmvc.member.model.dao.MemberDao;
import com.spring.springmvc.member.model.vo.Member;

import common.JDBCTemplate;

@Service
public class MemberService {

	@Autowired
	MemberDao mDao;

	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public String idCheck(String id) {

		String res = "";
		Connection conn = jdt.getConnection();

		try {

			res = mDao.idCheck(conn, id);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}

		return res;
	}

	public int insertMember(Map<String, Object> commandMap) {

		int res = 0;

		Connection conn = jdt.getConnection();

		try {
			res = mDao.insertMember(conn, commandMap);
			jdt.commit(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jdt.rollback(conn);
		} finally {
			jdt.close(conn);
		}

		return res;
	}
	
	public Member login(String id , String pw) {
		
		Member res = null;
		Connection conn = jdt.getConnection();
		
		try {
			res = mDao.login(conn, id, pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdt.close(conn);
		}
		
		return res;
	}

}
