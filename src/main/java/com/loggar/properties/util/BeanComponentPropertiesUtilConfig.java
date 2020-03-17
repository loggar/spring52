package com.loggar.properties.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/com/loggar/properties/util/props.config.xml")
public class BeanComponentPropertiesUtilConfig {
	@Bean(name = "componentBean")
	public ComponentBean componentBean() {
		return new ComponentBean();
	}
}
