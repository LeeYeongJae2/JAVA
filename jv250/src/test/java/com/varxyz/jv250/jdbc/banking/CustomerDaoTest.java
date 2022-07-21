package com.varxyz.jv250.jdbc.banking;

import java.util.List;

public class CustomerDaoTest {

	public static void main(String[] args) {
		CustomerDao dao = new CustomerDao();
		List<Customer> customerList = dao.findAllCustomers();
		
		for (Customer customer : customerList) {
			System.out.println(customer.getName());
			
		}
		System.out.println("--------------------------");
		
		Customer customer = dao.findCustomerBySssn("945693-1234567");
		System.out.println(customer.getName());
		System.out.println("--------------");
//		
//		Customer c = new Customer();
//		c.setName("여포");
//		c.setSsn("940524-587692");
//		c.setPhone("010-9542-4576");
//		c.setCustomerId("spring");
//		c.setPasswd("0000");
//
//		dao.addCustomer(c);
//		System.out.println(c.getName());
		
		
		
		
	}

}
