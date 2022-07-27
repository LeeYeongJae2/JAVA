package com.varxyz.banking.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Account {
	
	private long aid;
	private Customer customer;
	private long customerId;
	private String accountNum;
	private char accType;
	private double balance;
	private double interestRate;
	private Date regDate;
	
	public Account(){
		super();
	}
	
	
	
}
