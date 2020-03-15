package com.loggar.annotation.scan;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigComponentScanTest {
	private static ApplicationContext applicationContext;

	@Test
	public void componentScan() {
		applicationContext = new AnnotationConfigApplicationContext(ConfigComponentScan.class);

		List<String> beanNames = Arrays.asList(applicationContext.getBeanDefinitionNames());

		for (String beanName : applicationContext.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}

		Assertions.assertTrue(beanNames.contains("configComponentScan"));
		Assertions.assertTrue(beanNames.contains("cat"));
		Assertions.assertTrue(beanNames.contains("dog"));
		Assertions.assertTrue(beanNames.contains("myBean"));
	}
}
