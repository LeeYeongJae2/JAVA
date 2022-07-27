package com.varxyz.banking.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.banking.DataSourceConfig;
import com.varxyz.banking.domain.Customer;
import com.varxyz.banking.service.CustomerService;

@Controller("example4.addCustomerController")
public class AddCustomerController {

	@GetMapping("/example1/hello")
	public String hello() {
		return "example1/hello";
	}
	
	@GetMapping("/example4/add_customer")
	public String addCustomerForm() {
		return "example4/add_customer";
	}

	@PostMapping("/example4/add_customer")
	public String addCustomer(Customer customer, Model model) { // Model 만 따로 사용할 수 있음, View 사용 안함
		// 받은정보 customer테이블에 insert한다
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		CustomerService s = context.getBean("customerService", CustomerService.class);
		s.addUser(customer);
		model.addAttribute("customerCommand", customer);
		return "example4/success_add_customer";
	}
}
