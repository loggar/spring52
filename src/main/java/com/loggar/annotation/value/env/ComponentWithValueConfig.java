package com.loggar.annotation.value.env;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:datasource.dbcp.1.dev.properties")
public class ComponentWithValueConfig {

	@Bean
	public ComponentValue getComponentWithValue() {
		return new ComponentValueFieldInjection();
	}

  /*
	 * With Spring frameworks Context version 4 and below:
	 * PropertySourcesPlaceHolderConfigurer Bean only required for @Value("{}") annotations. Remove this bean if you are not using @Value annotations for injecting properties.
	 */
	// @Bean
	// public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	// 	return new PropertySourcesPlaceholderConfigurer();
	// }
}
