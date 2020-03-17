package com.loggar.properties.util;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentWithPropertiesUtilTest {
	@Test
	public void componentWithPropertyValue() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(ComponentBeanPropertiesUtilConfig.class);
		ctx.refresh();

		ComponentBean componentBean = ctx.getBean("componentBean", ComponentBean.class);
		ctx.close();

		Assertions.assertEquals(componentBean.getProp1Key1(), "value1");
		Assertions.assertEquals(componentBean.getProp1Key2(), "value2");
		Assertions.assertEquals(componentBean.getProp2Key1(), "value3");
		Assertions.assertEquals(componentBean.getProp2Key2(), "value4");
	}

	@Test
	public void mapWithPropertyValue() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(ComponentMapPropertiesUtilConfig.class);
		ctx.refresh();

		@SuppressWarnings("unchecked") Map<String, String> propMap = ctx.getBean("propMap", Map.class);
		ctx.close();

		Assertions.assertEquals(propMap.get("prop1['key1']"), "value1");
		Assertions.assertEquals(propMap.get("prop1['key2']"), "value2");
		Assertions.assertEquals(propMap.get("prop2['key1']"), "value3");
		Assertions.assertEquals(propMap.get("prop2['key2']"), "value4");
	}

}
