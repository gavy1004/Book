package com.book.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	static Connection conn;
	
	public static Connection getConnect() {
		try {
			InitialContext ic = new InitialContext();
			javax.sql.DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/book");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
