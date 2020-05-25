package com.spring.springmvc.member.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.springmvc.member.model.vo.Member;

@Repository
public class MemberDao {

	// 빈에 등록
	@Autowired
	SqlSessionTemplate session;

	public String idCheck(String id) {

		return session.selectOne("Member.selectId", id);
	}

	public int insertMember(Map<String, Object> commandMap) {

		return session.insert("Member.insertMember", commandMap);
	}

	public Member login(Map<String, Object> commandMap) {

		return session.selectOne("Member.login", commandMap);
	}

}
