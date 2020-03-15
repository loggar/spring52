package com.loggar.annotation.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.loggar.annotation.beans.MyBean;
import com.loggar.annotation.beans.MyBeanChild;

@Configuration
public class ConfigAnnotationBean {
	@Bean
	public MyBean myBean() {
		return new MyBeanChild();
	}
}
