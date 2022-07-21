package com.varxyz.jv200.mod001.test;

public class LibaryTest {

	public static void main(String[] args) {
		
		Book b = new Book("어린왕자", 1234);
		Book c = new Book("집가자", 6547);
		Libary.addBook(b.getname(),b.getnumber());
		Libary.addBook(c.getname(),c.getnumber());
		Libary.getBook(1234);
		Libary.getBook(6547);
		
		
	
	}



}
