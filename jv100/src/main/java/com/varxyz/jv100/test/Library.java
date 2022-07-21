package com.varxyz.jv100.test;

public class Library {
	private static Library lib = new Library();
	
	private Library() {
		// 도서관을 한번만 생성할 수 있게 생성자에 private걸기
	}
	
	public static Library getLibrary() {
		return lib;
	}
	
	private static int listLeng = 100; //저장소내 책의 최대 개수
	private static String[][] bookList = new String[listLeng][2];
	private static int bookIndex = 0;
	private String giveBook = "";
	
	
	public void addBook(Book book) {
		if (bookIndex >= listLeng) { // 책의 갯수가 도서관 최대 저장 개수인 100권보다 많다면
			listLeng *= 2; //저장공간을 2배로한다
			String[][] copy = bookList;
			bookList = new String[listLeng][2];
			System.arraycopy(copy, 0, bookList, 0, copy.length); 
		}
		bookList[bookIndex][0] = book.getBookName(); // 책 0행 0열에 저장
		bookList[bookIndex][1] = book.getSerial(); // 고유번호 0행 1열에 저장 숫자를 String 형으로 변환후 저장한다
		bookIndex++; //행을 증가시킨다
	}
	
	public String getBook(int serial) {
		for(int i = 0; i < bookList.length; i++) { //저장된 책의 인덱스 개수만큼 검사
			if (Integer.toString(serial).equals(bookList[i][1])) {  //내가 찾을 책의 인덱스 번호를 받아와서 String 형으로 변환후 equals 비교하면 찾는다
				giveBook = bookList[i][0]; //찾았으면 giveBook에 저장
			}
		}
		return giveBook; //책을 반환한다
	}
	
}
