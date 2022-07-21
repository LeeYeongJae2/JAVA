package com.varxyz.bankig.domain;

public class Account { //계좌

	protected String accoutNum; // 계좌번호
	protected double balance; // 통장
	protected Customer customer;

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

}
