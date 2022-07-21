package com.varxyz.jvx330.intro;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		
		String config="com/varxyz/jvx330/intro/beans.xml"; // 위치를 찾는 경로 써놓은거
		GenericApplicationContext context = new GenericXmlApplicationContext(config); //경로인 config를 보낸후 context에 저장한다
		Hello hello = context.getBean("helloBean", Hello.class); //타입이 달라서 저장불가능하니 Hello타입으로 바꿔서 저장한다는말 
//		Hello hello = (Hello)context.getBean("helloBean"); 이거랑 위에거랑 같은말 
		
		System.out.println(hello.sayHello("Spring"));
		context.close();
	}
}
