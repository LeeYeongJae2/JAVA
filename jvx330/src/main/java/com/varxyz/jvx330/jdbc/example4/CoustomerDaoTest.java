package com.varxyz.jvx330.jdbc.example4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.DataSourceConfig;

public class CoustomerDaoTest {

	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		CustomerDao dao = context.getBean("customerDao", CustomerDao.class);
		
		String date = "2022-07-22";
		SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date formDate = null;
		
		try {
			formDate = newDtFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		findallCustomers(dao);
		findAllCustomerByRegDate(dao, formDate);
		findCustomerByEmail(dao,"home@naver.com");
		countCistomers(dao);
		
		context.close();
	}
	
	
	public static void findallCustomers(CustomerDao dao) {
		System.out.println("findallCustomers");
		dao.findAllCustomers().forEach(c -> System.out.println(c));
		System.out.println("--------------------------");
	}
	
	public static void findAllCustomerByRegDate(CustomerDao dao, Date reDate) {
		System.out.println("findAllCustomerByRegDate");
		dao.findAllCustomerByRegDate(reDate).forEach(c -> System.out.println(c));
		System.out.println("--------------------------");
	}
	
	public static void findCustomerByEmail(CustomerDao dao, String email) {
		System.out.println("findCustomerByEmail");
		System.out.println(dao.findCustomerByEmail(email));
		System.out.println("--------------------------");
	}
	
	public static void countCistomers(CustomerDao dao) {
		System.out.println("countCistomers");
		System.out.println(dao.countCistomers());
	}
}
