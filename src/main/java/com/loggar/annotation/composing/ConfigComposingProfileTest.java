package com.loggar.annotation.composing;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

public class ConfigComposingProfileTest {
	@Test
	public void basicDataSource() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		ConfigurableEnvironment env = ctx.getEnvironment();

		MutablePropertySources propertySources = env.getPropertySources();
		Map<String, Object> myMap = new HashMap<>();
		myMap.put("spring.profiles.active", "development");
		propertySources.addFirst(new MapPropertySource("MY_MAP", myMap));
		printEnv(env);

		ctx.register(DatabaseConfigProfile.class);
		ctx.refresh();
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		ctx.close();

		BasicDataSource basicDataSource = (BasicDataSource) dataSource;

		Assertions.assertNotNull(basicDataSource);
		Assertions.assertTrue("localhost:00001".equals(basicDataSource.getUrl()));
	}

	private static void printEnv(ConfigurableEnvironment env) {
		printSources(env);
		System.out.println("---- System properties -----");
		printMap(env.getSystemProperties());
		System.out.println("---- System Env properties -----");
		printMap(env.getSystemEnvironment());
	}

	private static void printSources(ConfigurableEnvironment env) {
		System.out.println("---- property sources ----");
		for (PropertySource<?> propertySource : env.getPropertySources()) {
			System.out.println("name =  " + propertySource.getName() + "\nsource = " + propertySource.getSource().getClass() + "\n");
		}

	}

	private static void printMap(Map<?, ?> map) {
		map.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));

	}
}
