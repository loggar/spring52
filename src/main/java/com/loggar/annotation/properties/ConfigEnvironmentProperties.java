package com.loggar.annotation.properties;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.loggar.annotation.beans.MyBean;
import com.loggar.annotation.beans.MyBeanChild;

@Configuration
@PropertySource("classpath:/com/loggar/annotation/properties/env.inject.properties")
public class ConfigEnvironmentProperties {
	@Inject Environment env;

	@Bean
	public MyBean myBean() {
		MyBean myBean = new MyBeanChild();
		myBean.setName(env.getProperty("mybean.name2"));
		return myBean;
	}
}
