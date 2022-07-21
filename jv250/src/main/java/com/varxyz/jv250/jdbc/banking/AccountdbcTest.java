package com.varxyz.jv250.jdbc.banking;

import java.sql.*;


public class AccountdbcTest {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul"; // db url을 가져온다
		String id = "jv250";
		String passwd = "jv250";

		try {
			Class.forName(driver); // 드라이브를 연결한다 try catch 필수
			System.out.println("LOADED DRIVER ----> " + driver);

			Connection con = DriverManager.getConnection(url, id, passwd); // db와 연결한다 try catch 필수
			System.out.println("CONNECTED TO ----> " + url);

			select(con);
			insert(con);
			select(con);
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void select(Connection con) {
		String sql = "SELECT * FROM Account";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql); // 결과를 rs에 받는다
			while (rs.next()) { // next는 테이블행을 돌면서 데이터가 있으면 true 없으면 false를 반환한다

				long aid = rs.getLong("aid"); // 테이블에 해당 cid 데이터를 받아온다
				String customerId = rs.getString("accountNum"); // 테이블에 해당 customerId에 데이터를 받아온다
				double balance = rs.getDouble("balance");
				double interestRate = rs.getDouble("interestRate");
				double overdraft = rs.getDouble("overdraft");
				char accountType = rs.getString("accountType").charAt(0);

				System.out.println(aid);
				System.out.println(customerId);
				System.out.println(balance);
				System.out.println(interestRate);
				System.out.println(overdraft);
				System.out.println(accountType);
				System.out.println("----------------");

			}
			pstmt.close();
			System.out.println("SELECT COMPLETED....\n");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void insert(Connection con) {
		String sql = "INSERT INTO Account (accountNum, balance, interestRate, overdraft, accountType, customerId) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "456-784-548");
			pstmt.setDouble(2, 300.0);
			pstmt.setDouble(3, 0.03);
			pstmt.setDouble(4, 0.0);
			pstmt.setString(5, String.valueOf('S'));
			pstmt.setDouble(6, 1005);
			pstmt.executeUpdate();

			pstmt.close();
			System.out.println("NEW ACCOUNT INSERTED...\n");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
