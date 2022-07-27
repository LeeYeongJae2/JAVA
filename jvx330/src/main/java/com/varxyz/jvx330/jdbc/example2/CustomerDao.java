package com.varxyz.jvx330.jdbc.example2;

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

	public List<Customer> findAllCustomers() {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer";

		return jdbcTemplate.query(sql, new RowMapper<Customer>() {  // query는 여러개 있을때 사용한다 

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer(rs.getLong("cid"), rs.getString("email"), rs.getString("passwd"),
						rs.getString("name"), rs.getString("ssn"), rs.getString("phone"), rs.getTimestamp("regDate"));
				return customer;
			}

		});

	}

	public List<Customer> findAllCustomerByRegDate(Date regDate) {
		String sql = "SELECT cid, email, passwd, name ,ssn, phone, regDate" + " FROM Customer WHERE DATE(regDate)=?";

		return jdbcTemplate.query(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer(rs.getLong("cid"), rs.getString("email"), rs.getString("passwd"),
						rs.getString("name"), rs.getString("ssn"), rs.getString("phone"), rs.getTimestamp("regDate"));
				return customer;
			}

		}, regDate);
	}

	public Customer findCustomerByEmail(String email) {
		String sql = "SELECT cid, email, passwd, name ,ssn, phone, regDate" + " FROM Customer WHERE email=?";

		return jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() { //queryForObject 는 1개만 존재할때 사용한다 안그러면 오류

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer(rs.getLong("cid"), rs.getString("email"), rs.getString("passwd"),
						rs.getString("name"), rs.getString("ssn"), rs.getString("phone"), rs.getTimestamp("regDate"));
				return customer;
			}
		}, email);
	}

	public long countCistomers() {
		String sql = "SELECT count(*) FROM Customer";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}

}
