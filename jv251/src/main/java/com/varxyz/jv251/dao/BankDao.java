package com.varxyz.jv251.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.varxyz.jv251.domain.Account;

public class BankDao {
	
	public BankDao(){
		
	}
	
	public List<Account> addMoney(String accoutNum) {
		String sql = "SELECT * FROM Customer WHERE accoutNum=?";
		List<Account> list = new ArrayList<>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				
				con = DateSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, accoutNum);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					
					
				}
				
			} finally {
				DateSourceManager.close(rs,pstmt,con);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
}
