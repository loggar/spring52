package com.loggar.annotation.scan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.loggar.config.beans.MyBean;
import com.loggar.config.beans.MyBeanChild;

@Configuration
@ComponentScan(basePackages = "com.loggar.config.beans")
public class ConfigComponentScan {
	@Bean
	public MyBean myBean() {
		return new MyBeanChild();
	}
}
