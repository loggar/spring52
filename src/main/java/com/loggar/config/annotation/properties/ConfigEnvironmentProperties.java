package com.loggar.config.annotation.properties;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.loggar.config.beans.MyBean;
import com.loggar.config.beans.MyBeanChild;

@Configuration
@PropertySource("classpath:/env.inject.properties")
public class ConfigEnvironmentProperties {
	@Inject Environment env;

	@Bean
	public MyBean myBean() {
		MyBean myBean = new MyBeanChild();
		myBean.setName(env.getProperty("mybean.name2"));
		return myBean;
	}
}
