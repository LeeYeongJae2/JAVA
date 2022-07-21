package com.varxyz.mod1;

import java.io.*;


public class FileInputStreamTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int totalByes = 0;
		try {
			try {
				fis = new FileInputStream("test.txt");
				fos = new FileOutputStream("test_copy.txt");
				for (int readByte; (readByte = fis.read()) != -1;) {
					fos.write(readByte);
					totalByes++;
				}
				
			} finally {
				fos.close();
				fis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\n전체 바이트수: " + totalByes + "bytes.");
	}
}
