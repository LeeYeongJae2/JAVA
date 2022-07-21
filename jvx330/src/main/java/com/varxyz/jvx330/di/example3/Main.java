package com.varxyz.jvx330.di.example3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Main {
	public static void main(String[] args) {
		
//		// xml사용해서 하는 방법
//		String config = "com/varxyz/jvx330/di/example3/beans.xml";
//		GenericApplicationContext context = new GenericXmlApplicationContext(config);
//		MemberService emp = context.getBean("user", MemberService.class);
//		System.out.println(emp.getAllMembers());
//		context.close();
		
		// 자바코드로 하는방법
		GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService service = context.getBean("memberService", MemberService.class);
		service.getAllMembers().forEach(member -> System.out.println(member)); //람다식으로 한거
		// 위에 람다식을 풀어놓은거
//		List<Member> list = service.getAllMembers();
//		for (Member member : list) {
//			System.out.println(member);
//		}
		context.close();
		
	}
}
