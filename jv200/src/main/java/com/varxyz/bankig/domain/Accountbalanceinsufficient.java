package com.varxyz.bankig.domain;

public class Accountbalanceinsufficient extends RuntimeException {
	//예외 처리하기 위한 클래스이다
	public  Accountbalanceinsufficient (String msg) {
		super(msg);
	}
}
