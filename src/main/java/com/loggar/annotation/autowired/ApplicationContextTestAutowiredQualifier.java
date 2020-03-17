package com.loggar.annotation.autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.loggar.annotation.components.ArbitraryDependency;
import com.loggar.annotation.components.ArbitraryDependencyChild1;

@Configuration
public class ApplicationContextTestAutowiredQualifier {
	@Bean(name = "autowiredFieldDependency")
	public ArbitraryDependency autowiredFieldDependency() {
		ArbitraryDependency autowiredFieldDependency = new ArbitraryDependency();
		return autowiredFieldDependency;
	}

	@Bean(name = "anotherAutowiredFieldDependency")
	public ArbitraryDependency anotherAutowiredFieldDependency() {
		ArbitraryDependency anotherAutowiredFieldDependency = new ArbitraryDependencyChild1();
		return anotherAutowiredFieldDependency;
	}
}
