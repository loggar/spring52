package com.loggar.annotation.value.env;

import org.springframework.beans.factory.annotation.Value;

public class ComponentValueFieldInjection implements ComponentValue {
	@Value("${java.home}") String prop1;

	@Value("${url}") String url;

	@Override
	public String getProp1() {
		return prop1;
	}

	@Override
	public String getUrl() {
		return url;
	}

}
