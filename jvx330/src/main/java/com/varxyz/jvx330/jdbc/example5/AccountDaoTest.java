package com.varxyz.jvx330.jdbc.example5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Account;
import com.varxyz.jvx330.jdbc.DataSourceConfig;

public class AccountDaoTest {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		AccountDao dao = new context.getBean("accountDao", AccountDao.class);

		dao.addAccount(dao);
		System.out.println("------------------");

	}

	public static void addAccount(Account dao) {
		System.out.println("addAccount");
		dao.addAccount();
	}

}
