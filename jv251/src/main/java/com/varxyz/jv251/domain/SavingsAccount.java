package com.varxyz.jv251.domain;

import java.util.Date;

import com.varxyz.jv251.exception.Accountbalanceinsufficient;

public class SavingsAccount extends Account {
	private double interestRate; //이자율
	
	public SavingsAccount() {
		
	}

	
	 public SavingsAccount (String accountNum, double balance) {
	      this(accountNum,balance, 0.0);
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
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}


	public void setRegDate(Date date) {
		
		
	}



	
}
