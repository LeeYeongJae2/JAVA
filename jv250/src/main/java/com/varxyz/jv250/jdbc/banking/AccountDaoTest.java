package com.varxyz.jv250.jdbc.banking;

import java.util.*;


public class AccountDaoTest {

	public static void main(String[] args) {
		AccountDao dao = new AccountDao();
		
		SavingsAccount sa = new SavingsAccount();
		sa.setAccoutNum("567-89-0123");
		sa.setBalance(123456789.0);
		sa.setCustomer(new Customer(1005));
		sa.setInterestRate(0.04);
		sa.setRegDate(new Date());
		sa.setAccountType('S');
		dao.addAccount(sa);
		
		for (Account account : dao.findAccountBySsn("901213-1234567")) {
			System.out.println(account.getCustomer().getName());
		}
	}

}
