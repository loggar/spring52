package com.loggar.annotation.properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.loggar.annotation.beans.MyBean;

public class ConfigValuePropertiesTest {
	@Test
	public void myBean() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(ConfigValueProperties.class);
		ctx.refresh();
		MyBean myBean = ctx.getBean(MyBean.class);
		ctx.close();

		Assertions.assertNotNull(myBean);
		Assertions.assertTrue("the name of myBean 2".equals(myBean.getName()));
	}
}
