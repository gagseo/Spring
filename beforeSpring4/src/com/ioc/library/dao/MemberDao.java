package com.ioc.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ioc.library.vo.Member;
//=======================================
// 전략 패턴
// Context(시스템의 플로우는 고정시켜 놓고) 
// Strategy(전략(ConnectionMaker)을 바꿔가면서 취하는 패턴)
//=======================================

public class MemberDao {

	// ConnectionMaker에게 의존하고있다.
	ConnectionMaker connectionMaker;

	public MemberDao() {

	}

	// 생성자를 통한 의존성 주입
	public MemberDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

	// setter 메서드를 활용한 의존성 주입(DI)
	public void setConnectionMaker(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

	public void insertMember(Member member) throws ClassNotFoundException, SQLException {

		// 1. DB 연결에 필요한 컨넥션 객체를 가져오기
		// 2. 매개변수로 넘어온 값들을 활용해서 쿼리를 작성하고 쿼리를 실행하기

		// 3. 사용한 Connection과 PreparedStatement를 닫아주기

		Connection conn = connectionMaker.getConnection();

		String sql = "insert into tb_member(m_id,m_password,m_email) values(?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, member.getId());
		pstm.setString(2, member.getPassword());
		pstm.setString(3, member.getE_mail());

		pstm.executeUpdate();

		pstm.close();
		conn.close();

	}

	public Member selectMember(String id) throws ClassNotFoundException, SQLException {

		Member member = new Member();

		Connection conn = connectionMaker.getConnection();

		String sql = "select * from tb_member where m_id = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			member.setId(rs.getString(1));
			member.setPassword(rs.getString(2));
			member.setE_mail(rs.getString(3));
		}

		rs.close();
		pstm.close();
		conn.close();

		return member;
	}

}
