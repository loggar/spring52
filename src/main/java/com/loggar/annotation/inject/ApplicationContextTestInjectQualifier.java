package com.loggar.annotation.inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.loggar.annotation.component.ArbitraryDependency;
import com.loggar.annotation.component.ArbitraryDependencyChild1;

@Configuration
public class ApplicationContextTestInjectQualifier {
	@Bean(name = "defaultFile")
	public ArbitraryDependency defaultFile() {
		ArbitraryDependency defaultFile = new ArbitraryDependency();
		return defaultFile;
	}

	@Bean(name = "namedFile")
	public ArbitraryDependency namedFile() {
		ArbitraryDependency namedFile = new ArbitraryDependencyChild1();
		return namedFile;
	}
}
