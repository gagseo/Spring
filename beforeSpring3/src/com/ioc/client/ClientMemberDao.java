package com.ioc.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ioc.library.dao.MemberDao;

// MemberDao를 상속받아서 클라이언트가 구현해야 하는 Dao
public class ClientMemberDao extends MemberDao {

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bm", "test1");

		return conn;
	}

}
