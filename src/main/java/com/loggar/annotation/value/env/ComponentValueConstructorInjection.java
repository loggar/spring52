package com.loggar.annotation.value.env;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ComponentValueConstructorInjection implements ComponentValue {
	String prop1;
	String url;

	public ComponentValueConstructorInjection(@Value("${java.home}") String prop1, @Value("${url}") String url) {
		this.prop1 = prop1;
		this.url = url;
	}

	@Override
	public String getProp1() {
		return prop1;
	}

	@Override
	public String getUrl() {
		return url;
	}

}
