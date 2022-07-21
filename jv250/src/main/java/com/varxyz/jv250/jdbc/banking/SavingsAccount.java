package com.varxyz.jv250.jdbc.banking;

import java.util.Date;

public class SavingsAccount extends Account {
	private static final double DEFALUT_INTFEREST_RATE = 0.03;
	private double interestRate; //이자율
	
	public SavingsAccount() {
		
	}

	
	 public SavingsAccount (String accountNum, double balance) {
	      this(accountNum,balance,DEFALUT_INTFEREST_RATE);
	   }
	 
	 public SavingsAccount (String accountNum,double balance, double interestRate) {
		super(accountNum,balance);
		this.interestRate = interestRate;
	}
	
	 
	 

	public void withdraw(double amount) {
		if (balance - amount < 0) { //예외발생
			throw new Accountbalanceinsufficient("잔고부족");
		}
		super.balance -= amount;
	}

	public double getInterestRate() {
		return DEFALUT_INTFEREST_RATE;
	}
	
	public void setInterestRate(double interestRate) {
		
	}


	public void setRegDate(Date date) {
		
		
	}



	
}
