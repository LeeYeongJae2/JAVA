package com.varxyz.jv200.mod003;

import java.util.*;

public class MapExample {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>(); //map 딕셔너리이다
		map.put(Integer.valueOf(1),"유비");
		map.put(2, "관우"); // 문법적으로는 틀렸지만 내부적으로 2를받아서 Integer형으로 박싱해준다
		map.put(Integer.valueOf(3), "장비");
		System.out.println(map.get(Integer.valueOf(2)));
		
		Set<Integer> set = map.keySet();
		for (Integer integer : set) {
			System.out.println(integer);
		}
	}
}
