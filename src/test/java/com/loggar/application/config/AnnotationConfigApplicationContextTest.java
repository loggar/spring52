package com.loggar.application.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.loggar.application.config.BeanConfigExample;
import com.loggar.beans.MyBean;

public class AnnotationConfigApplicationContextTest {
	@Test
	public void myBean() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(BeanConfigExample.class);
		ctx.refresh();
		MyBean myBean = ctx.getBean(MyBean.class);
		ctx.close();

		Assertions.assertNotNull(myBean);
	}
}
