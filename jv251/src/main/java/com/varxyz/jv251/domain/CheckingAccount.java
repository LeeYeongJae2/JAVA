package com.varxyz.jv251.domain;

import com.varxyz.jv251.exception.InsufficientBalanceException;

public class CheckingAccount extends Account {
	private double overdraftAmount;
	
	public CheckingAccount() {

	}

	public CheckingAccount(String accountNum, double balance, double overdraftAmount) {
		super(accountNum, balance);
		this.overdraftAmount = overdraftAmount;
	}

	public void withdraw(double amount) throws InsufficientBalanceException {
		if (balance < amount) { // 잔고보다 출금금액이 많을시
			double overdraftNeeded = amount - balance;
			if (overdraftAmount < overdraftNeeded) {
				throw new OverdraftExecetion("에러: 대월금초과", balance,overdraftNeeded);

			} else {
				balance = 0.0;
				overdraftAmount -= overdraftNeeded;
	
			}
		} else {
			balance -= amount;
		}
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;

	}

}
