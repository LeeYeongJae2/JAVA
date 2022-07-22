package com.varxyz.jvx330.lifrcycle.example3;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifrcycle.AappConfig;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Horse {
	
	private static int count;

	
	
	public Horse() {
		count++;
	}
	
	private static int getHorse() {
		return count;
	}
	
	public static void main(String[] args) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(AappConfig.class);
		
		context.getBean("horse", Horse.class);
		context.getBean("horse", Horse.class);
		context.getBean("horse", Horse.class);
		context.getBean("horse", Horse.class);
		context.getBean("horse", Horse.class);
		System.out.println(Horse.getHorse());
		context.close();

	}
	
}
