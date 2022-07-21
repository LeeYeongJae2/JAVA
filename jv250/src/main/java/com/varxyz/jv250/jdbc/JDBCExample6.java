package com.varxyz.jv250.jdbc;

import java.io.PrintStream;
import java.sql.*;


public class JDBCExample6 {
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
			String sql = "INSERT INTO Account (accountNum,balance,interestRate,overdraft,accountType,customerId) VALUES (?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,"123-456-78");
			stmt.setString(2,"100000");
			stmt.setString(3,"123");
			stmt.setString(4,"456");
			stmt.setString(5,"v");
			stmt.setString(6,"1005");
			stmt.executeUpdate();
			
			System.out.println("INSERTED....."); 
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
