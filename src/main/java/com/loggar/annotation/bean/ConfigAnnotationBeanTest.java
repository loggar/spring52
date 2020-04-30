package com.loggar.annotation.bean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.loggar.annotation.beans.MyBean;

public class ConfigAnnotationBeanTest {
	@Test
	public void myBean() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(ConfigAnnotationBean.class);
		ctx.refresh();
		MyBean myBean1 = ctx.getBean(MyBean.class);
		MyBean myBean2 = ctx.getBean(MyBean.class);
		ctx.close();

		Assertions.assertNotNull(myBean1);
		Assertions.assertTrue(myBean1 == myBean2);
	}
}
