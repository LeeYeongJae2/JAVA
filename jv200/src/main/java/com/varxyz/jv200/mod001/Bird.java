package com.varxyz.jv200.mod001;

public class Bird implements Flyer {
	@Override
	public void fly() {
		System.out.println("새 : 날개");
	}

	@Override
	public void takeoff() {
		System.out.println("새 : 이륙하기");
	}

	@Override
	public void land() {
		System.out.println("새 : 착륙하기");
	}
}
