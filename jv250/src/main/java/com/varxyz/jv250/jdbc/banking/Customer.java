package com.varxyz.jv250.jdbc.banking;

import java.util.*;


public class Customer { //고객
	private long cid; //프라임 넘버
	private String name; //이름
	private String ssn; //주민번호
	private String phone; //폰번호
	private String customerId; //아이디
	private String passwd; //비번
	private List<Account> accountList;
	
	
	
	public Customer() {
		
	}
	
	public Customer(long cid) {
		this.cid = cid;
	}
	
	public Customer(String name, String ssn, String phone) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	
	public List<Account> getAccountList() {
		return accountList;
	}

	
	
	public String getSsn() {
		return ssn;
	}
	
	public String getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public long getCid() {
		return cid;
	}
	
	public void setCid(long cid) {
		this.cid = cid;
	}
	
	public void setCustomerId(String id) {
		this.customerId = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	
	
	
}


