package com.loggar.config.annotation.properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.loggar.config.beans.MyBean;

public class ConfigEnvironmentEnvTest {
	@Test
	public void myBean() {
		String envMyBeanName = "the name of myBean";
		System.setProperty("mybean.name", envMyBeanName);

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(ConfigEnvironmentEnv.class);
		ctx.refresh();
		MyBean myBean = ctx.getBean(MyBean.class);
		ctx.close();

		Assertions.assertNotNull(myBean);
		Assertions.assertTrue(envMyBeanName.contentEquals(myBean.getName()));
	}
}
