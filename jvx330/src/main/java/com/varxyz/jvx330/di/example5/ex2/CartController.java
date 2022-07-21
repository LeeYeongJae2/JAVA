package com.varxyz.jvx330.di.example5.ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CartController {
	
	
	@Autowired
	@Qualifier("sessionCartService") // 지정하고자 하는 이름을 쓴다
	private CartService service;
	
	@Autowired
	@Qualifier("cookieCartService") // 지정하고자 하는 이름을 쓴다
	private CartService service2;
	
	public CartController() {
		System.out.println("CartController 생성");
	}
	
	public void processRequest() {
		service.addItem();
		service2.addItem();
	}
	
	
}
