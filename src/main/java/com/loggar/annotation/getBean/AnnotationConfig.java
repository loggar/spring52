package com.loggar.annotation.getBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.loggar.annotation.beans.Lion;
import com.loggar.annotation.beans.Tiger;

@Configuration
public class AnnotationConfig {
	@Bean(name = { "tiger", "kitty" })
	@Scope(value = "prototype")
	Tiger getTiger(String name) {
		return new Tiger(name);
	}

	@Bean(name = "lion")
	Lion getLion() {
		return new Lion("Hardcoded lion name");
	}

}
