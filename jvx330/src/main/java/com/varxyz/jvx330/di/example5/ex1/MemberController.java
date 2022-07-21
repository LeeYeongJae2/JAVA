package com.varxyz.jvx330.di.example5.ex1;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberController {

	@Autowired // MemberService를 자동으로 beans.xml에넣어준다
	private MemberService memberService;
	
	public MemberController() {
		System.out.println("빈생성: " + this);
	}
	
	public void processRequest() {
		memberService.addMember("java", "1111");
	}
}
