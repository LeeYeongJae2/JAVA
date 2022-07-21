package com.varxyz.jv250.jdbc;

import java.io.PrintStream;
import java.sql.*;


public class JDBCExample5 {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver"; 
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul"; //db url을 가져온다
		String id = "jv250";
		String passwd = "jv250";
		
		try {
			Class.forName(driver); //드라이브를 연결한다 try catch 필수
			System.out.println("LOADED DRIVER ----> " + driver);
			
			Connection con = DriverManager.getConnection(url,id,passwd); //db와 연결한다 try catch 필수
			System.out.println("CONNECTED TO ----> " + url);
			
			//문자열로 spl에 전달한다
			String sql = "DELETE FROM Customer  WHERE cid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1,1004);
			stmt.executeUpdate();
			
			System.out.println("INSERTED....."); 
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
