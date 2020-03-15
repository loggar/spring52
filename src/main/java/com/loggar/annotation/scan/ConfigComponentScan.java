package com.loggar.annotation.scan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.loggar.annotation.beans.MyBean;
import com.loggar.annotation.beans.MyBeanChild;

@Configuration
@ComponentScan(basePackages = "com.loggar.annotation.beans")
public class ConfigComponentScan {
	@Bean
	public MyBean myBean() {
		return new MyBeanChild();
	}
}
