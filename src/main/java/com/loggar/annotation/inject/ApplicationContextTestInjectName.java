package com.loggar.annotation.inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.loggar.annotation.components.ArbitraryDependency;
import com.loggar.annotation.components.ArbitraryDependencyChild2;

@Configuration
public class ApplicationContextTestInjectName {
	@Bean
	public ArbitraryDependency yetAnotherFieldInjectDependency() {
		ArbitraryDependency yetAnotherFieldInjectDependency = new ArbitraryDependencyChild2();
		return yetAnotherFieldInjectDependency;
	}
}
