package com.varxyz.jv250.jdbc.banking;

import java.util.*;

public class CustomeServiceImpl2 implements CustomerService {
	private List<Customer> customerList = new ArrayList<>();
	//고객관리 시스템
	
	@Override
	public void addCustomer (Customer customer) {
		if (getCustomerBySsn(customer.getSsn()) == null) {
			customerList.add(customer);
		}
	}
	
	@Override
	public Customer getCustomerBySsn(String ssn) {
		for (Customer c : customerList) {
			if (ssn.equals(c.getSsn())) {
				return c;
			}
		}
		return null;
	}
	
	
	@Override
	public Collection<Customer> getAllCustomers(){
		return customerList;
	}

	@Override
	public int getNumOfCustomers() {
		return customerList.size();
	}

	@Override
	public Customer getCistomerBuSsn(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
