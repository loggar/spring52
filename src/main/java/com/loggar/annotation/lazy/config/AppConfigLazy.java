package com.loggar.annotation.lazy.config;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
public class AppConfigLazy {
	@Bean
	public BeanRegion getRegion() {
		return new BeanRegion();
	}

	@Bean
	public BeanCountry getCountry() {
		return new BeanCountry();
	}

	@Test
	public void givenLazyAnnotation_whenConfigClass_thenLazyAll() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfigLazy.class);
		ctx.refresh();

		ctx.getBean(BeanRegion.class);
		ctx.getBean(BeanCountry.class);

		ctx.close();
	}
}
