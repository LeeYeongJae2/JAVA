package com.varxyz.jv251.dao;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DateSourceManager {
	//final은 값을 할당해줘야한다 안그러면 에러 아니면 생성자에서라도 만들어줘야 한다
	private static final String JDBC_URL; 
	private static final String JDBC_USER;
	private static final String JDBC_PASSWD;
	
	static { 
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("jdbc.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Class.forName(props.getProperty("JDBC_DRIVER")); // 드라이브를 연결한다 try catch 필수
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		JDBC_URL = props.getProperty("JDBC_URL");
		JDBC_USER = props.getProperty("JDBC_USER");
		JDBC_PASSWD = props.getProperty("JDBC_PASSWD");
		
		System.out.println("JDBC_URL = " + JDBC_URL);
		System.out.println("JDBC_USER = " + JDBC_USER);
		System.out.println("JDBC_PASSWD = " + JDBC_PASSWD);
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWD);
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (con != null) {
			con.close();
		}
	}
	
	
	public static void close(PreparedStatement pstmt, Connection con) throws SQLException{
		close(null,pstmt, con);
	}
	
	
}

