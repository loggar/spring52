package com.loggar.annotation.lazy.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.loggar.annotation.lazy.autowired" })
public class AppConfigLazyWithAutowired {
	@Bean
	public BeanRegion getRegion() {
		return new BeanRegion();
	}

	@Test
	public void givenLazyAnnotation_whenAutowire_thenLazyBean() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfigLazyWithAutowired.class);
		ctx.refresh();

		BeanRegion region = ctx.getBean(BeanRegion.class);
		BeanCity city = region.getCityInstance();
		System.out.println("BeanCity instance is now available " + city.toString());

		ctx.close();
	}
}
