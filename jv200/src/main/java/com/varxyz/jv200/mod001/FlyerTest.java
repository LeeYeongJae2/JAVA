package com.varxyz.jv200.mod001;

public class FlyerTest {

	public static void main(String[] args) {
		Flyer f = new Airplane(); 
		Flyer f1 = new Bird();
		f.takeoff();
		f1.takeoff();
	}

}
