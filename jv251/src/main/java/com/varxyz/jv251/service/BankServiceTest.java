package com.varxyz.jv251.service;

import java.util.List;

import com.varxyz.jv251.domain.Account;
import com.varxyz.jv251.domain.Customer;
import com.varxyz.jv251.exception.CustomerNotFoundException;










public class BankServiceTest {
	public static void main(String[] args) {
		BankService service = BankService.getInstance();
		String name = "조조";
		String ssn = "89383-383567";
		String phone = "010-4434-3232";
		String userId = "framework";
		String passwd = "1111";
		String accountNum = null;
		// 1.신규 고객등록
//		service.addCustomer(name, ssn, phone, userId, passwd);
//		try {
//			// 2. SavingsAccount 생성
//			service.addSavimgsAccount(7000.0, 0.4, ssn);
//		} catch (CustomerNotFoundException e) {
//			e.printStackTrace();
//		}
		// 3. 고객등록 확인
		Customer customer = service.getCustomerBySsn(ssn);
		System.out.println(customer);
		
		//4. 고객 계좌 목록 확인
		List<Account> myList = service.getAccountBySsn(ssn);
		for (Account account : myList) {
			System.out.println(account);
			accountNum = account.getAccountNum();
		}
		
		service.getAccountByAccountNum(accountNum);
	}
}
