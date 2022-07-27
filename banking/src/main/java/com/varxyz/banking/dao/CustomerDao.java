package com.varxyz.banking.dao;



import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.banking.domain.Customer;


public class CustomerDao {

	private static final int VARCHAR = 0;
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void addUser(Customer customer){ // 유저추가
		String sql = "INSERT INTO Customer(userId, passwd, name, ssn,"
				+ " phone) VALUES (?,?,?,?,?)";
		
		jdbcTemplate.update(sql, customer.getUserId(), customer.getPasswd(),
				customer.getName(), customer.getSsn(), customer.getPhone());
	}
	
	
}
