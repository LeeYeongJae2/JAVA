package com.varxyz.jv250.jdbc.banking;

import java.util.*;

public class AccountServiceImpl implements AccountService {
	private static AccountService service = new AccountServiceImpl();
	private List<Account> accountList = new ArrayList<Account>();
	private CustomerService customerService;

	
	private AccountServiceImpl() {
		customerService = CustomerServiceImpl.getInstance();
	}
	
	public static AccountService getInstance() {
		return service;
	}
	
	@Override
	public Account createSavingsAccount(String accountNum, double balance,
			double interestRate) {
		return new SavingsAccount(accountNum, balance, interestRate);
	}
	
	
	
	@Override
	public Account createCheckingAccount(String accountNum, double balance,
			double overdraftAmount) {
		return new CheckingAccount(accountNum, balance, overdraftAmount);
	}
	
	
	/**
	 * 신규계좌등록
	 * 계좌정보와 고객정보 전체를 캡슐화
	 */
	
	@Override
	public void addAccount(Account account) {
		accountList.add(account);
	}
	
	/**
	 * 전달된 ssn을 통해 고객을 조회한 후 신규 계좌 등록
	 */
	
	@Override
	public void addAccount(Account account, String ssn) {
		Customer customer = customerService.getCustomerBySsn(ssn);
		account.setCustomer(customer);
	}
	
	@Override
	public List<Account> getAccountBySsn(String ssn) {
		return null;
	}
	
	@Override
	public Account getAccountByAccountNum(String accountNum) {
		for(Account a : accountList) {
			if(a.accoutNum == accountNum){
				return a;
			}
		}
		return null;
	}


}
