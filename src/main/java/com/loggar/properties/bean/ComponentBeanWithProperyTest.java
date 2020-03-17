package com.loggar.properties.bean;

import java.util.Properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentBeanWithProperyTest {
	@Test
	public void componentBean() {
		@SuppressWarnings("resource") ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/loggar/properties/bean/baens.1.property.xml");
		ComponentBean componentBean = context.getBean("componentBean", ComponentBean.class);

		Properties properties = componentBean.getProperties();
		Assertions.assertEquals(properties.get("key1"), "value1");
		Assertions.assertEquals(properties.get("key2"), "value2");
	}

	@Test
	public void componentBean_util_properties() {
		@SuppressWarnings("resource") ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/loggar/properties/bean/baens.2.util-properties.xml");
		ComponentBean componentBean = context.getBean("componentBean", ComponentBean.class);

		Properties properties = componentBean.getProperties();
		Assertions.assertEquals(properties.get("key1"), "value3");
		Assertions.assertEquals(properties.get("key2"), "value4");
	}

	@Test
	public void componentBean_util_properties_property_file() {
		@SuppressWarnings("resource") ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/loggar/properties/bean/baens.3.util-properties.xml");
		ComponentBean componentBean = context.getBean("componentBean", ComponentBean.class);

		Properties properties = componentBean.getProperties();
		Assertions.assertEquals(properties.get("key1"), "value5");
		Assertions.assertEquals(properties.get("key2"), "value6");
	}

	@Test
	public void componentBean_util_properties_xml_file() {
		@SuppressWarnings("resource") ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/loggar/properties/bean/baens.4.util-properties.xml");
		ComponentBean componentBean = context.getBean("componentBean", ComponentBean.class);

		Properties properties = componentBean.getProperties();
		Assertions.assertEquals(properties.get("key1"), "value7");
		Assertions.assertEquals(properties.get("key2"), "value8");
	}
}
