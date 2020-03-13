package com.loggar.config.annotation.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.loggar.config.beans.MyBean;
import com.loggar.config.beans.MyBeanChild;

@Configuration
public class ConfigAnnotationBean {
	@Bean
	public MyBean myBean() {
		return new MyBeanChild();
	}
}
