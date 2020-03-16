package com.loggar.annotation.value.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.loggar.annotation.component.ComponentWithValue;

@Configuration
@PropertySource("classpath:datasource.dbcp.1.dev.properties")
public class ComponentWithValueConfig {

	@Bean
	public ComponentWithValue getComponentWithValue() {
		return new ComponentWithValue();
	}
}
