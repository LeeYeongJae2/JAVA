package com.varxyz.jvx330.lifrcycle.example2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifrcycle.AappConfig;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Eagle {
	
	private String name;
	
	public void attachWings() {
		System.out.println("initMethod 호출 : Eagle의 날개를 달아줍니다.");
	}
	
	
	public void detachWings() {
		System.out.println("datachWings 호출 : Eagle의 날개를 회수합니다");
	}

	
	public static void main(String[] args) {
		
		GenericApplicationContext context = new AnnotationConfigApplicationContext(AappConfig.class);
		
		Eagle ealge = context.getBean("ealge", Eagle.class);
		System.out.println("Eagle final name : " + ealge.getName());
		context.close();
	}
	
	
	
	
	
	
	
	
	
}
