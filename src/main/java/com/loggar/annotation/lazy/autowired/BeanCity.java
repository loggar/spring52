package com.loggar.annotation.lazy.autowired;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class BeanCity {
	public BeanCity() {
		System.out.println("BeanCity bean initialized");
	}

	@Override
	public String toString() {
		return "BeanCity.instance";
	}
}
