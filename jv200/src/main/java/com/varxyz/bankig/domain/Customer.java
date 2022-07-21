package com.varxyz.bankig.domain;

import java.util.*;


public class Customer { //고객
	private String name; //이름
	private String ssn; //주민번호
	private String phone; //폰번호
	private String id; //아이디
	private String passwd; //비번
	

	
	public Customer (String name, String ssn, String phone, String id, String passswd) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.id = id;
		this.passwd = passwd;
	}

	
	public String getSsn() {
		return ssn;
	}
	
	public String getId() {
		return id;
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
	

	
	
	
}


