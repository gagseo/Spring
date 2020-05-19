package com.ioc.library.dao;

import java.sql.Connection;
import java.sql.SQLException;

//사용자가 이 인터페이스를 구현한 즉 이 ConnectionMaker 
public interface ConnectionMaker {

	
	public Connection getConnection() throws SQLException, ClassNotFoundException;
	
	
	
}
