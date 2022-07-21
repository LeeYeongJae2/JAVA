package com.varxyz.jv200.mod003;
import java.util.*;
public class ListExample2 {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(new Integer(42));
		list.add(new Integer(2));
		int total = ((Integer)list.get(0)).intValue();  //intValue() 문자형 리스트에서 뽑아서 정수형으로 변환한다
		int total2 = ((Integer)list.get(1)).intValue();
		System.out.println(total);
		System.out.println(total2);
		
		ArrayList<String> a = new ArrayList<String>();	
		a.add("배고프다");
		a.add("롤하고싶다");
		a.add("어렵다");
		
		for (String string : a) { //일반 배열은 length  Array는 size
			System.out.println(string);
		}
		
		
	}

}
