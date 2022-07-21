package com.varxyz.jvx330.di.example6;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.varxyz.jvx330"}) // 이경로안에 다찾아서 beans를 찾아라
public class AppConfig {

}
