package com.varxyz.jv300.mod009;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	NamingService nameService = NamingService.getInstance();
	DataSource data = (DataSource) nameService.getAttribute("dataSource");

	public void addUsers(User user) { // User 추가
		String sql = "INSERT INTO User(userId, passwd, userName, ssn, email, addr) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			Connection con = data.getConnection(); // DB와 연결
			PreparedStatement pstmt = con.prepareStatement(sql); // con에 sql을 입력하는 것을 pstmt에 담음

			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPasswd());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getSsn());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getAddr());
			pstmt.executeUpdate();

			data.close(pstmt, con);
			System.out.println("INSERTED....");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	 전체 고객 검색
	public List<User> findAllUsers() {
		String sql = "SELECT * FROM User";
		List<User> userList = new ArrayList<>(); // List 배열로 데이터를 받기 위해 배열 생성
		try {
			Connection con = data.getConnection(); // DB와 연결
			PreparedStatement pstmt = con.prepareStatement(sql); // con에 sql을 입력하는 것을 pstmt에 담음
			ResultSet rs = pstmt.executeQuery();
			try {
				while (rs.next()) { // 해당 테이블에서 데이터를 찾으면 true, 없으면 false
					User user = new User();
					user.setUserId(rs.getString("userId"));
					user.setPasswd(rs.getString("passwd"));
					user.setUserName(rs.getString("userName"));
					user.setSsn(rs.getString("ssn"));
					user.setEmail(rs.getString("email"));
					user.setAddr(rs.getString("addr"));
					userList.add(user);
				}
			} finally {
				data.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList; // List 에 결과값을 받음
	}

	// 아이디로 유저 검색
	public User findUser(String userId) {
		String sql = "SELECT * FROM User WHERE userId = ?";
		User user = null;

		try {
			Connection con = data.getConnection(); // DB와 연결
			PreparedStatement pstmt = con.prepareStatement(sql); // con에 sql을 입력하는 것을 pstmt에 담음
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery(); // 데이터베이스에서 데이터를 가져와서(pstmt 입력) 결과 집합을 반환
			try {
				if (rs.next()) { // 해당 테이블에서 데이터를 찾으면 true, 없으면 false
					user = new User();
					user.setUserId(rs.getString("userId"));
					user.setPasswd(rs.getString("passwd"));
					user.setUserName(rs.getString("userName"));
					user.setSsn(rs.getString("ssn"));
					user.setEmail(rs.getString("email"));
					user.setAddr(rs.getString("addr"));
				}
			} finally {
				data.close(rs, pstmt, con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
