package com.varxyz.jvx330.di.example1;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		
		String config="com/varxyz/jvx330/di/example1/beans.xml"; // 위치를 찾는 경로 써놓은거
		GenericApplicationContext context = new GenericXmlApplicationContext(config); //경로인 config를 보낸후 context에 저장한다
		
		Foo foo = context.getBean("foo", Foo.class); //타입이 달라서 저장불가능하니 Foo타입으로 바꿔서 저장한다는말 
		System.out.println(foo);
		
		Foo foo2 = context.getBean("foo2", Foo.class); //타입이 달라서 저장불가능하니 Foo타입으로 바꿔서 저장한다는말 
		System.out.println(foo2);
		context.close();
	}
}
