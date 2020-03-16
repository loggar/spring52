package com.loggar.annotation.inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.loggar.annotation.component.ArbitraryDependency;
import com.loggar.annotation.component.ArbitraryDependencyChild2;

@Configuration
public class ApplicationContextTestInjectName {
	@Bean
	public ArbitraryDependency yetAnotherFieldInjectDependency() {
		ArbitraryDependency yetAnotherFieldInjectDependency = new ArbitraryDependencyChild2();
		return yetAnotherFieldInjectDependency;
	}
}
