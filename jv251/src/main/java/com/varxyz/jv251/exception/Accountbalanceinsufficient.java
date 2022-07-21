package com.varxyz.jv251.exception;

@SuppressWarnings("serial")
public class Accountbalanceinsufficient extends RuntimeException {
	//예외 처리하기 위한 클래스이다
	private double balance;
	public  Accountbalanceinsufficient (String msg) {
		super(msg);
	}
	
	public  Accountbalanceinsufficient (String msg, double balance) {
		super(msg);
		this.balance = balance;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() + "현재 잔고는" + balance + "입니다";
	}
	
	
}
