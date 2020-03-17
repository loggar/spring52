package com.loggar.annotation.value.env;

import org.springframework.beans.factory.annotation.Value;

public class ComponentWithValue {
	@Value("${java.home}") String prop1;

	@Value("${url}") String url;

	public String getProp1() {
		return prop1;
	}

	public String getUrl() {
		return url;
	}

}
