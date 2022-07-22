package com.varxyz.jvx330.di.example6;




import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor // 생성자를 대신해준다
@ToString // toString 해줘라
@EqualsAndHashCode //equals 여기서 처리한다

public class MenuItem {
	
	private String name;
	private String price;
	
}
