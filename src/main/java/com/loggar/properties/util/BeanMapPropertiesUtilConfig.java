package com.loggar.properties.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/com/loggar/properties/util/props.config.xml")
public class BeanMapPropertiesUtilConfig {
	private @Value("#{prop1['key1']}") String prop1Key1;
	private @Value("#{prop1['key2']}") String prop1Key2;
	private @Value("#{prop2['key1']}") String prop2Key1;
	private @Value("#{prop2['key2']}") String prop2Key2;

	@Bean(name = "propMap")
	public Map<String, String> propMap() {
		Map<String, String> m = new HashMap<>();
		m.put("prop1['key1']", prop1Key1);
		m.put("prop1['key2']", prop1Key2);
		m.put("prop2['key1']", prop2Key1);
		m.put("prop2['key2']", prop2Key2);

		return m;
	}
}
