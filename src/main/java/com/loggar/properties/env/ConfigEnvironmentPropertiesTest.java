package com.loggar.properties.env;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.loggar.annotation.beans.MyBean;

public class ConfigEnvironmentPropertiesTest {
	@Test
	public void myBean() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(ConfigEnvironmentProperties.class);
		ctx.refresh();
		MyBean myBean = ctx.getBean(MyBean.class);
		ctx.close();

		System.out.println(myBean.getName());

		Assertions.assertNotNull(myBean);
		Assertions.assertTrue("the name of myBean 2".contentEquals(myBean.getName()));
	}
}
