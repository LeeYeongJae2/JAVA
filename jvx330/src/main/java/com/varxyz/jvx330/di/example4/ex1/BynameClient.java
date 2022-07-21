package com.varxyz.jvx330.di.example4.ex1;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BynameClient {
	
	public NamingService namingServicel;
	
	//jmsNamingService
	public NamingService getJmsNamingService() {
		return namingServicel;
	}
	
	public void setJmsNamingService(NamingService namingService) {
		this.namingServicel = namingService;
		
	}
	
	public void service(String name) {
		Object o = namingServicel.lookup(name);
		System.out.println(o);
	}
	
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example4/ex1/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		BynameClient client = context.getBean("byNameClient", BynameClient.class);
		client.service("muQueue");
		context.close();
	}
	
}
