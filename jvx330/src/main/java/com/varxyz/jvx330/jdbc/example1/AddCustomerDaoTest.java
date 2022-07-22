package com.varxyz.jvx330.jdbc.example1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.DataSourceConfig;


public class AddCustomerDaoTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);

		AddCustomerDao dao = context.getBean("addCustomerDao", AddCustomerDao.class);
		
		addCustomer(dao);
		addCustomer2(dao);
		addCustomer3(dao);

		context.close();

	}

	public static void addCustomer(AddCustomerDao dao) {
		Customer c = new Customer();
		c.setEmail("home@naver.com");
		c.setPasswd("1111");
		c.setName("박강산");
		c.setSsn("700222-1234567");
		c.setPhone("010-5698-2285");
		dao.addCustomer(c);
		System.out.println("-inserted-");
	}
	
	public static void addCustomer2(AddCustomerDao dao) {
		Customer c = new Customer();
		c.setEmail("home@naver.com");
		c.setPasswd("2222");
		c.setName("박강산");
		c.setSsn("700222-1234567");
		c.setPhone("010-5698-2285");
		dao.addCustomer2(c);
		System.out.println("-inserted-");
	}
	
	public static void addCustomer3(AddCustomerDao dao) {
		Customer c = new Customer();
		c.setEmail("home@naver.com");
		c.setPasswd("3333");
		c.setName("박강산");
		c.setSsn("700222-1234567");
		c.setPhone("010-5698-2285");
		
		long key = dao.addCustomer3(c);
		System.out.println("key" + key);
		System.out.println("inserted");
		
	}
	
	

}
