package com.varxyz.jv200.mod001;

import java.util.Iterator;

public class AddArgruments2 {
	public static void main(String[] args) {
		try {
			int sum = 0;
			for (String arg : args) {
				sum += Integer.parseInt(arg);
			}
			System.out.println("sum = " + sum);
			
		} catch (Exception e) {
			System.err.println("one of the command-line" + "arguments is not an integer");
		}
	}
}
