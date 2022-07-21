package com.varxyz.jv251.dao;

import java.sql.*;
import java.util.*;
import com.varxyz.jv251.domain.*;

public class AccountDao {
	

	public AccountDao() { 
		
	}

	/**
	 * 신규 계좌 등록
	 * 
	 * @param account
	 */

	public void addAccount(Account account) {
		String sql = "INSERT INTO Account(accountNum,balance,interestRate,overdraft,accountType,customerId) VALUES(?,?,?,?,?,?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = DateSourceManager.getConnection();
				pstmt = con.prepareStatement(sql); // prepareStatement는 DB에 쿼리를 날릴때 사용한다
				pstmt.setString(1, account.getAccountNum()); //
				pstmt.setDouble(2, account.getBalance());

				if (account instanceof SavingsAccount) { // account가 saving 인지 checking인지 확인하는 if문
					SavingsAccount sa = (SavingsAccount) account;
					pstmt.setDouble(3, sa.getInterestRate());
					pstmt.setDouble(4, 0.0);
					pstmt.setString(5, String.valueOf('S'));

				} else {
					CheckingAccount ca = (CheckingAccount) account;
					pstmt.setDouble(3, 0.0);
					pstmt.setDouble(4, ca.getOverdraftAmount());
					pstmt.setString(5, String.valueOf("C"));
				}
				pstmt.setLong(6, account.getCustomer().getCid());
				pstmt.executeUpdate();
				System.out.println("INSERTED.....");
			} finally {
				DateSourceManager.close(pstmt,con);
			}
			System.out.println("NEW ACCOUNT INSERTED......\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 전달된 주민번호를 가진 특정 고객의 계좌 목록 조회
	 */

	public List<Account> findAccountBySsn(String ssn) {
		String sql = "SELECT a.aid, a.accountNum, a.balance, a.interestRate, a.overdraft, a.accountType, c.name, c.ssn, c.phone, a.regDate"
	            + " FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn = ?";
		List<Account> list = new ArrayList<>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DateSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ssn);
				rs = pstmt.executeQuery();
				Account account = null;
				while (rs.next()) {
					if (rs.getString("accountType").charAt(0) == 'S') {
						account = new SavingsAccount();
						((SavingsAccount) account).setInterestRate(rs.getDouble("interestRate"));
					} else {
						account = new CheckingAccount();
						((CheckingAccount) account).setOverdraftAmount(rs.getDouble("overdraft"));

					}
					account.setAid(rs.getLong("aid"));
					account.setAccoutNum(rs.getString("accountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setCustomer(new Customer(rs.getString("name"), rs.getString("ssn"), rs.getString("phone")));
					account.setRegDate(rs.getDate("regDate"));

					list.add(account);
				}

			} finally {
				DateSourceManager.close(pstmt,con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public Account findAccountByAccountNum(String accountNum) {
		String sql = "SELECT a.aid, a.accountNum, a.balance, a.interestRate, a.overdraft, a.accountType, c.name, c.ssn, c.phone, a.regDate"
	           + " FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE a.accountNum = ?";
		Account account = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DateSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, accountNum);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					if (rs.getString("accountNum") == accountNum) {
						account = new SavingsAccount();
						((SavingsAccount) account).setInterestRate(rs.getDouble("interestRate"));
					} 
					account.setAid(rs.getLong("aid"));
					account.setAccoutNum(rs.getString("accountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setCustomer(new Customer(rs.getString("name"), rs.getString("ssn"), rs.getString("phone")));
					account.setRegDate(rs.getDate("regDate"));					
				}

			} finally {
				DateSourceManager.close(pstmt,con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return account;
	}

}
