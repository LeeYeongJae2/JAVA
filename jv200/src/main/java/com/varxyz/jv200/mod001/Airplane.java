package com.varxyz.jv200.mod001;

public class Airplane implements Flyer, Vehicle {

	@Override
	public void fly() {
		System.out.println("비행기 : 날개");
	}

	@Override
	public void takeoff() {
		System.out.println("비행기 : 이륙하기");
	}

	@Override
	public void land() {
		System.out.println("비행기 : 착륙하기");
	}
	
}
