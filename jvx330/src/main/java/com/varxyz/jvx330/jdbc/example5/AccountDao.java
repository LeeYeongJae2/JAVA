package com.varxyz.jvx330.jdbc.example5;

import java.sql.Types;
import java.util.List;
import static java.sql.Types.*;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.jvx330.jdbc.Account;
import com.varxyz.jvx330.jdbc.example3.CustomerRowMapper;


@Repository("accountDao")
public class AccountDao {

	private JdbcTemplate jdbcTemplate;
	
	public AccountDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Autowired
	public void addAccount(Account account) { // 추가한다
		String sql = "INSERT INTO Account(customerId, accountNum, accType, balance,"
				+ " interestRate, overAmount, overAmount)";
		SavingsAccount sa = null;
		CheckingAccount ca = null;
		Object[] args = null;
		int[] types = new int[] {CHAR,CHAR,DOUBLE,DOUBLE,DOUBLE,BIGINT};
		
		if (account instanceof SavingsAccount) {
			sa = (SavingsAccount)account;
			args = new Object[] {
					sa.getAccountNum(), String.valueOf(sa.getAccType()), sa.getBalance(),
					sa.getInterestRate(), sa.getCustomer().getCid()
			};
		}else {
			ca = (CheckingAccount)account;
			args = new Object[] {
					ca.getAccountNum(), String.valueOf(ca.getAccType()),
					ca.getBalance(), 0.0, ca.getOverdraftAmount(),
					ca.getCustomer().getCid()
			};
		}
		
		jdbcTemplate.update(sql, args,types);
	}
	
	public List<Account> findAccountsBySsn(String ssn) { // 주민번호로 찾는다
		String sql = "SELECT a.aid, a.accountNum, a.balance, a.interestRate, a.overdraft, a.accountType, c.name, c.ssn, c.phone, a.regDate"
	            + " FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn = ?";
//		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class),ssn);
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(),ssn);
	}
	
	public List<Account> findAccountsByCustomerId(long customerId) {
		String sql = "SELECT cid, customerId, accountNum, accType, balance, "
				+ "interestRate, overAmount, overAmount , regDate FROM Account WHERE customerId=?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class),customerId);
	}
	
}
