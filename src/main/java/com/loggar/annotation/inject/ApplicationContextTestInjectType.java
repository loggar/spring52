package com.loggar.annotation.inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.loggar.annotation.components.ArbitraryDependency;

@Configuration
public class ApplicationContextTestInjectType {

	@Bean
	public ArbitraryDependency injectDependency() {
		ArbitraryDependency injectDependency = new ArbitraryDependency();
		return injectDependency;
	}
}
