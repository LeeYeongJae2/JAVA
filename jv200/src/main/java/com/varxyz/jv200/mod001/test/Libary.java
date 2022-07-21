package com.varxyz.jv200.mod001.test;

public class Libary {
	private static int Max = 99;
	private static String[] Book = new String[Max];
	private static int[] Number = new int[Max];
	private static int a = 0;
	private static Libary ln = new Libary();
	
	public static Libary getlibary() {
		return ln;
	}
	
	public static void addBook(String name, int num) {
		if (a == Max) {
			Max *= 2;
		}
		Book[a] = name;
		Number[a] = num;
		System.out.println(name+"책이 등록 되었습니다");
		a++;
	}
	
	public static void getBook(int num) {
		for (int i = 0; i < Book.length; i++) {
			if (Number[i] == num) {
				System.out.println(Book[i] + "책을 대출하셨습니다");
			}
			
		}
		
	}

	
}
