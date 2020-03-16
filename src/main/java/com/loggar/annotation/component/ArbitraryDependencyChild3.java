package com.loggar.annotation.component;

import org.springframework.stereotype.Component;

@Component(value = "autowiredFieldDependency")
public class ArbitraryDependencyChild3 extends ArbitraryDependency {
	private final String label = "Child_3 Arbitrary Dependency";

	public String toString() {
		return label;
	}
}
