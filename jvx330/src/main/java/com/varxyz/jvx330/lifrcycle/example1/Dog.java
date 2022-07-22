package com.varxyz.jvx330.lifrcycle.example1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifrcycle.AappConfig;



public class Dog implements InitializingBean, DisposableBean{
	private String name;
	
	public Dog(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	

	@Override
	public void afterPropertiesSet() throws Exception { //내가 실행 하고싶은거 나오기전에 먼저 실행한다
		System.out.println("afterPropertiesSet 호출");
		if (name == null) {
			System.out.println("Property name must be set");
		}else {
			System.out.println(name);
		}
	}
	

	@Override
	public void destroy() throws Exception { // 실행할거 실행한후 마지막에 실행된다
		System.out.println("destroy 호출");
		
	}

	
	
	public static void main(String[] args) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(AappConfig.class);
		
		Dog dog = context.getBean("dog", Dog.class);
		System.out.println("Dogs final name : " + dog.getName());
		context.close();
		
	}
	

	
	
}
