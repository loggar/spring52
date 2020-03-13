package com.loggar.resource.classpath;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

public class ResourceFromApplicationContext {
	ApplicationContext context;

	public Resource loadEmployees() {
		return context.getResource("classpath:data/employees.dat");
	}

}
