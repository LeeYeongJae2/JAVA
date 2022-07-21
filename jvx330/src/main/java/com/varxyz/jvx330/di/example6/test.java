package com.varxyz.jvx330.di.example6;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.support.GenericApplicationContext;

public class test {
	public static void main(String[] args) {

		GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		MenuItemService itemService = context.getBean("menuItemService", MenuItemService.class);

		itemService.addMenuItem(new MenuItem("아메리카노", "3000"));
		itemService.addMenuItem(new MenuItem("라떼는말이야", "50000"));

		List<MenuItem> list = itemService.findAllMenuItem();
		for(MenuItem item: list) {
			System.out.println(item);
		}
		System.out.println("------------------------------");

		MenuItem item = itemService.findMenuItemByName("아메리카노");
		System.out.println(item);

		context.close();

	}
}
