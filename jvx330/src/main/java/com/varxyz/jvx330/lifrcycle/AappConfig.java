package com.varxyz.jvx330.lifrcycle;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.varxyz.jvx330.lifrcycle.example1.Dog;
import com.varxyz.jvx330.lifrcycle.example2.Eagle;
import com.varxyz.jvx330.lifrcycle.example3.Goat;
import com.varxyz.jvx330.lifrcycle.example3.Horse;

@Configuration
public class AappConfig {
	
	@Bean
	public Dog dog() {
		
		/**
		 * xml로 적으면
		 *	<bean name="dog" class="com.varxyz.jvx330.lifrcycle.example1.Dog">
		 *		<constructor-arg index=0 type="java.lang.String value="플루토"/>
		 *		<>
		 * 
		 */
		
		
		Dog d = new Dog("플루토");
		d.setName("볼트");
		return d;
		
	}
	
	@Bean (initMethod = "attachWings", destroyMethod = "detachWings")
	public Eagle eagle() {
		Eagle e = new Eagle();
		e.setName("독수리");
		return e;
	}
	
	@Bean
	@Scope("singleton")
	public Goat goat() {
		return new Goat();
	}
	
	
	@Bean
	@Scope("prototype")
	public Horse horse() {
		return new Horse();
	}
	
	
	
	
}
