package com.varxyz.bankig.domain;

public class SavingsAccount extends Account {
	private static final double DEFALUT_INTFEREST_RATE = 0.03;
	private double interestRate; //이자율
	
	 
	
	SavingsAccount (String accountNum, double balance) {
	      this(accountNum,balance,DEFALUT_INTFEREST_RATE);
	   }
	 
	SavingsAccount (String accountNum,double balance, double interestRate) {
		super(accountNum,balance);
		this.interestRate = interestRate;
	}
	
	 
	 

	public void withdraw(double amount) {
		if (balance - amount < 0) { //예외발생
			throw new Accountbalanceinsufficient("잔고부족");
		}
		super.balance -= amount;
	}
	
}
