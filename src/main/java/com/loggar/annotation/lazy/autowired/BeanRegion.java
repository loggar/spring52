package com.loggar.annotation.lazy.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class BeanRegion {
	@Lazy @Autowired private BeanCity city;

	public BeanRegion() {
		System.out.println("BeanRegion bean initialized");
	}

	public BeanCity getCityInstance() {
		return city;
	}
}
