package com.ioc.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ioc.library.vo.Member;

public class MemberDao {

	public void insertMember(Member member) throws ClassNotFoundException, SQLException {

		// 1. DB 연결에 필요한 컨넥션 객체를 가져오기
		
		// 2. 매개변수로 넘어온 값들을 활용해서 쿼리를 작성하고 쿼리를 실행하기
		// 3. 사용한 Connection과 PreparedStatement를 닫아주기

		Connection conn = getConnection();
		
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

		Connection conn = getConnection();
		
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
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE");
	
		return conn;

	}
	
	

}
