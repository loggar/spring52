package com.loggar.properties.env;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.loggar.annotation.beans.MyBean;
import com.loggar.annotation.beans.MyBeanChild;

@Configuration
@PropertySource("classpath:/com/loggar/properties/env/env.inject.properties")
public class ConfigValueProperties {
	@Value("${mybean.name2}") String myBeanName;

	@Bean
	public MyBean myBean() {
		return new MyBeanChild(myBeanName);
	}

}
