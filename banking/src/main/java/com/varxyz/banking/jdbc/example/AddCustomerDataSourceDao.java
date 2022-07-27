package com.varxyz.banking.jdbc.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.banking.DataSourceConfig;
import com.varxyz.banking.domain.Customer;





public class AddCustomerDataSourceDao {
	private DataSource dataSource;
	
	
	public AddCustomerDataSourceDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Custome (email, passwd, name, ssn, phone)" + " VALUES(?,?,?,?,?)";
		
		try(Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, customer.getEmail());
				pstmt.setString(2, customer.getPasswd());
				pstmt.setString(3, customer.getName());
				pstmt.setString(4, customer.getSsn());
				pstmt.setString(5, customer.getPhone());
				
				pstmt.executeUpdate();
				con.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		AddCustomerDataSourceDao dao = context.getBean("addCustomerDataSourceDao", AddCustomerDataSourceDao.class);
		Customer c = new Customer();
		c.setEmail("afsdg@naver.com");
		c.setPasswd("1111");
		c.setName("여포");
		c.setSsn("800111-1234567");
		c.setPhone("010-5599-2285");
		dao.addCustomer(c);
		System.out.println("inserted-");
		context.close();
		
		
		
		
	}
	
	
	
	
	
	
}
