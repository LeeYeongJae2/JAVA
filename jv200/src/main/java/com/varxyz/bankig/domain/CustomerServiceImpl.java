package com.varxyz.bankig.domain;

import java.util.*;

public class CustomerServiceImpl implements CustomerService {
	private static CustomerService service = new CustomerServiceImpl();
	private Map<String, Customer> map = new HashMap<>();
	
	private CustomerServiceImpl() { //다른곳에서 못쓰게 만든다
		super();
	}
	
	public static CustomerService getInstance() {
		return service; 
	}
	
	@Override
	public void addCustomer (Customer customer) {
		if (!map.containsKey(customer.getSsn())) {
			map.put(customer.getSsn(),customer);
		}
	}
	
	@Override
	public Customer getCistomerBuSsn(String ssn) {
		if (map.containsKey(ssn)) {
			return map.get(ssn);
		}
		return null;
	}

	@Override
	public Customer getCustomerBySsn(String ssn) {
		if (map.containsKey(ssn)) {
			return map.get(ssn);
		}
		return null;
	}

	@Override
	public Collection<Customer> getAllCustomers() {
		return map.values();
	}

	@Override
	public int getNumOfCustomers() {
		return map.size();
	}
	

}
