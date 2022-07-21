package com.varxyz.jv250.jdbc.banking;
import java.sql.*;


public class Account { //계좌
	protected long aid;
	protected String accoutNum; // 계좌번호
	protected double balance; // 통장
	protected Customer customer;
	protected Date regDate;
	protected char accountType;
	
	public Account() {
		
	}

	public Account(String accountNum, double balance) {
		this.accoutNum = accountNum;
		this.balance = balance;
	}

	 public void deposite(double amount) {
		this.balance += amount;
	}

	 public String getAccountNum() {
		 return accoutNum;
	}
	 
	public void setAccoutNum(String accoutNum) {
		this.accoutNum = accoutNum;
	}

	 
	 public double getBalance() {
		 return balance;
	 }
	 
	 public void setBalance(double balance) {
		this.balance = balance;
	}
	 
	 public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	 
	 public Customer getCustomer() {
		return this.customer;
	}
	 
	public long getAid() {
		return aid;
	}
	
	public void setAid(long aid) {
		this.aid = aid;
	}
		
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	
	@Override
	public String toString() {
		return "Account [aid=" + aid + ", accoutNum=" + accoutNum + ", balance=" + balance + ", customer=" + customer
				+ ", regDate=" + regDate + ", accountType=" + accountType + "]";
	}
	
	public void setAccountType(char accountType) {
		this.accountType = accountType;
	}
	
	public char getAccountType() {
		return accountType;
	}

	public void setRegDate(Timestamp timestamp) {
		
		
	}

	
	
	
}
