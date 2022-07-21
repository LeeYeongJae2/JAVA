package com.varxyz.jv251.dao;

import java.sql.*;
import java.util.*;

import com.varxyz.jv251.domain.Customer;

public class CustomerDao {

	
	public CustomerDao() { 
	
	}
	
	public List<Customer> findAllCustomers(){ //모든 고객정보를 불러온다
		String sql = "SELECT * FROM Customer"; // DB에서 Customer리스트를 실행시킨다
		List<Customer> customerList = new ArrayList<>(); //리턴할 값을 담을 리스트
	
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DateSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery(); 
				while(rs.next()) {
					Customer c = new Customer();
					c.setCid(rs.getLong("cid"));
					c.setName(rs.getString("name"));
					c.setSsn(rs.getString("ssn"));
					c.setPhone(rs.getString("phone"));
					c.setUserId(rs.getString("userId"));
					customerList.add(c);
				}
			} finally {
				DateSourceManager.close(rs,pstmt,con);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	/**
	 * 주민번호로 고객 조회
	 * @param ssn
	 * @return
	 */
	
	public Customer findCustomerBySssn(String ssn){ //주민번호로 고객 조회
		String sql = "SELECT * FROM Customer WHERE ssn=?";
		Customer c = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DateSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ssn);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					c = new Customer();
					c.setCid(rs.getLong("cid"));
					c.setName(rs.getString("name"));
					c.setSsn(rs.getString("ssn"));
					c.setPhone(rs.getString("phone"));
					c.setUserId(rs.getString("userId"));
					c.setPasswd(rs.getString("passwd"));
					
				}
			} finally {
				DateSourceManager.close(rs,pstmt,con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	/**
	 * 신규 고객 등록
	 * @param customer 등록할 고객정보
	 */
	
	public void addCustomer(Customer customer) { //신규고객 등록
		String sql = "INSERT INTO Customer(name,ssn,phone,userId,passwd) VALUES(?,?,?,?,?)";
		try {
			Connection con = DateSourceManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getSsn());
			pstmt.setString(3, customer.getPhone());
			pstmt.setString(4, customer.getUserId());
			pstmt.setString(5, customer.getPasswd());
			pstmt.executeUpdate();
			DateSourceManager.close(pstmt,con);
			System.out.println("INSERTED.....");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
