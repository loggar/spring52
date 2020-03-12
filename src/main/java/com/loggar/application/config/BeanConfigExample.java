package com.loggar.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.loggar.beans.MyBean;
import com.loggar.beans.MyBeanChild;

@Configuration
public class BeanConfigExample {
	@Bean
	public MyBean myBean() {
		return new MyBeanChild();
	}
}
