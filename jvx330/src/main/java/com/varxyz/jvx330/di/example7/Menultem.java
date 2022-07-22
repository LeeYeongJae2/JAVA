package com.varxyz.jvx330.di.example7;

import com.varxyz.jvx330.di.example6.MenuItem;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor //생성자를 해준다
@ToString //toString 해준다
@EqualsAndHashCode // 다른곳에서 if로 equals로 비교 할때 여기서 값을 반환해준다

public class Menultem {
	
	private String name;
	private double price;
}
