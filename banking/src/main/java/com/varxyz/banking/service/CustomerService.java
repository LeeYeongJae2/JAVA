package com.varxyz.banking.service;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.varxyz.banking.dao.CustomerDao;
import com.varxyz.banking.domain.Customer;


@Component
public class CustomerService {
	
	private CustomerDao customerDao;
	
	@Autowired 
	public CustomerService(DataSource dataSource) {
		customerDao = new CustomerDao(dataSource);
	}
	
	
	public void addUser(Customer customer) {
		customerDao.addUser(customer);
	}
	
}
