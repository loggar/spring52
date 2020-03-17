package com.loggar.properties.util;

import org.springframework.beans.factory.annotation.Value;

public class ComponentBean {
	private @Value("#{prop1['key1']}") String prop1Key1;
	private @Value("#{prop1['key2']}") String prop1Key2;
	private @Value("#{prop2['key1']}") String prop2Key1;
	private @Value("#{prop2['key2']}") String prop2Key2;

	public String getProp1Key1() {
		return prop1Key1;
	}

	public String getProp1Key2() {
		return prop1Key2;
	}

	public String getProp2Key1() {
		return prop2Key1;
	}

	public String getProp2Key2() {
		return prop2Key2;
	}

}
