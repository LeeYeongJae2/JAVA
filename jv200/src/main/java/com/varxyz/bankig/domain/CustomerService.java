package com.varxyz.bankig.domain;
import java.util.*;

public interface CustomerService {
	void addCustomer(Customer customer);
	Customer getCustomerBySsn(String ssn);
	Collection<Customer>getAllCustomers();
	public int getNumOfCustomers();
	Customer getCistomerBuSsn(String ssn);

}
