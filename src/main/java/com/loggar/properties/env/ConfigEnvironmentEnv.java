package com.loggar.properties.env;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.loggar.annotation.beans.MyBean;
import com.loggar.annotation.beans.MyBeanChild;

@Configuration
public class ConfigEnvironmentEnv {
	@Autowired Environment env;

	@Bean
	public MyBean myBean() {
		MyBean myBean = new MyBeanChild();
		myBean.setName(env.getProperty("mybean.name"));
		return myBean;
	}
}
