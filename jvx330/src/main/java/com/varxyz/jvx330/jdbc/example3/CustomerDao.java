package com.varxyz.jvx330.jdbc.example3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.jvx330.jdbc.Customer;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Customer> findAllCustomers(){
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer";
		return jdbcTemplate.query(sql, new CustomerRowMapper());	
	}
	
	
	public List<Customer> findAllCustomerByRegDate(Date regDate) {
		String sql = "SELECT cid, email, passwd, name ,ssn, phone, regDate"
				+ " FROM Customer WHERE DATE(regDate)=?";
		return jdbcTemplate.query(sql, new CustomerRowMapper());
	}
	
	
	
	public Customer findCustomerByEmail(String email) {
		String sql = "SELECT cid, email, passwd, name ,ssn, phone, regDate"
				+ " FROM Customer WHERE email=?";
		return jdbcTemplate.queryForObject(sql, new CustomerRowMapper());
	}
	
	
	
	public long countCistomers() {
		String sql = "SELECT count(*) FROM Customer";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}
	
	
}
