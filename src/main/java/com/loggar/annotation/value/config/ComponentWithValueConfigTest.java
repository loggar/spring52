package com.loggar.annotation.value.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.loggar.annotation.component.ComponentWithValue;

public class ComponentWithValueConfigTest {
	@Test
	public void componentWithValue() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(ComponentWithValueConfig.class);
		ctx.refresh();
		ComponentWithValue componentWithValue = ctx.getBean(ComponentWithValue.class);
		ctx.close();

		System.out.println(componentWithValue.getProp1());
		System.out.println(componentWithValue.getUrl());

		Assertions.assertNotNull(componentWithValue);
		Assertions.assertEquals(componentWithValue.getUrl(), "localhost:00001");
	}
}
