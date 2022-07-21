package com.varxyz.jv200.mod002;
import java.util.Scanner;

public class PriemNum {
	
	public static void sum (int num) throws PriemNumTest {
		int a = 0;
		int[] b = new int[num];
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				a++;
			}
		}
		if (a == 2) {
			System.out.println(num + "는 소수입니다");
		}
		else {
			System.out.println(num + " 소수가 아닙니다 약수는");
			int c = 0;
			for (int i = 1; i <= num; i++) {
				if (num % i == 0) {
					b[c] = i;  
					c++;
					
				}
			}
			for (int i = 0; i < b[c]; i++) {
				if (b[i] == b[c] || b[i] > b[c]) {
					System.out.print(b[i] + "x" + b[c] + " = " + num);
					break;
				}
				System.out.print(b[i] + "x" + b[c] + " = " + num);
				c--;
			}
			throw new PriemNumTest("에러발생");
		}
		
	}

	

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int a;
			System.out.print("숫자를 입력하세요: ");
			a = s.nextInt();
			sum(a);
		} catch (Exception e) {
			e.getMessage();
			System.out.println(e.getMessage());
		}
	
	}
}
