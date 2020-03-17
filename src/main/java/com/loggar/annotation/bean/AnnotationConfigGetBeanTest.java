package com.loggar.annotation.bean;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanNotOfRequiredTypeException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.loggar.annotation.beans.Animal;
import com.loggar.annotation.beans.Lion;
import com.loggar.annotation.beans.Tiger;

public class AnnotationConfigGetBeanTest {
	AnnotationConfigApplicationContext ctx;

	@BeforeEach
	public void beforeEach() {
		ctx = new AnnotationConfigApplicationContext();
		ctx.register(AnnotationConfig.class);
		ctx.refresh();
	}

	@AfterEach
	public void afterEach() {
		ctx.close();
	}

	@Test
	public void getBeanByName() {
		Object lion = ctx.getBean("lion");

		Assertions.assertEquals(Lion.class, lion.getClass());

		Assertions.assertThrows(ClassCastException.class, () -> {
			@SuppressWarnings("unused") Tiger tiger = (Tiger) ctx.getBean("lion");
		});
	}

	@Test
	public void getBeanByType() {
		Lion lion = ctx.getBean(Lion.class);

		Assertions.assertEquals(Lion.class, lion.getClass());

		Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
			ctx.getBean(Animal.class);
		});

	}

	@Test
	public void getBeanByNameAndType() {
		Lion lion = ctx.getBean("lion", Lion.class);

		Assertions.assertEquals(Lion.class, lion.getClass());

		Assertions.assertThrows(BeanNotOfRequiredTypeException.class, () -> {
			ctx.getBean("lion", Tiger.class);
		});
	}

	@Test
	public void getBeanWithConstructor() {
		Tiger tiger = (Tiger) ctx.getBean("tiger", "Siberian");
		Tiger secondTiger = (Tiger) ctx.getBean("tiger", "Striped");
		Tiger tiger2 = ctx.getBean(Tiger.class, "Shere Khan");

		Assertions.assertEquals("Siberian", tiger.getName());
		Assertions.assertEquals("Striped", secondTiger.getName());
		Assertions.assertEquals("Shere Khan", tiger2.getName());
	}

}
