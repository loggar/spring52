package com.loggar.annotation.autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.loggar.annotation.components.ArbitraryDependency;

@Configuration
public class ApplicationContextTestAutowiredType {
	@Bean
	public ArbitraryDependency autowiredFieldDependency() {
		ArbitraryDependency autowiredFieldDependency = new ArbitraryDependency();
		return autowiredFieldDependency;
	}
}
