package com.varxyz.jv251.domain;

import com.varxyz.jv251.exception.InsufficientBalanceException;

@SuppressWarnings("serial")
public class OverdraftExecetion extends InsufficientBalanceException {
	private double overdraftAvail;
	public OverdraftExecetion(String msg, double balance, double overdraftAvail) {
		super(msg,balance);
		this.overdraftAvail = overdraftAvail;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() + "사용 가능한 대출액은" + overdraftAvail + "입니다";
	}
}
