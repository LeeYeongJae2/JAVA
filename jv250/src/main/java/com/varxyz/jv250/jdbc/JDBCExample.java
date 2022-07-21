	package com.varxyz.jv250.jdbc;

import java.io.PrintStream;
import java.sql.*;


public class JDBCExample {
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
			String sql = "SELECT * FROM Customer WHERE name='유비'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql); //결과를 rs에 받는다
			while(rs.next()) { //next는 테이블행을 돌면서 데이터가 있으면 true 없으면 false를 반환한다
				
				long cid = rs.getLong("cid"); //테이블에 해당 cid 데이터를 받아온다
				String customerId = rs.getString("customerId"); //테이블에 해당 customerId에 데이터를 받아온다
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				System.out.println(cid);
				System.out.println(customerId);
				System.out.println(name);
				System.out.println(phone);
				System.out.println("----------------");
				
			}
			//열었으면 반드시 닫아줘야한다 순서는 반대순서대로 닫아줘야한다 
			rs.close(); 
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			
		}
	}
}
