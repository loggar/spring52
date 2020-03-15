package com.loggar.config.annotation.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.loggar.config.beans.MyBean;
import com.loggar.config.beans.MyBeanChild;

@Configuration
@PropertySource("classpath:/com/loggar/config/annotation/properties/env.inject.properties")
public class ConfigValueProperties {
	@Value("${mybean.name2}") String myBeanName;

	@Bean
	public MyBean myBean() {
		return new MyBeanChild(myBeanName);
	}

}
