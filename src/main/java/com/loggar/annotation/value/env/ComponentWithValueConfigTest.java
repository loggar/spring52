package com.loggar.annotation.value.env;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentWithValueConfigTest {
	@Test
	public void componentWithValue() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(ComponentWithValueConfig.class);
		ctx.refresh();
		ComponentValue componentWithValue = ctx.getBean(ComponentValue.class);
		ctx.close();

		System.out.println(componentWithValue.getProp1());
		System.out.println(componentWithValue.getUrl());

		Assertions.assertNotNull(componentWithValue);
		Assertions.assertEquals(componentWithValue.getUrl(), "localhost:00001");
	}
}
