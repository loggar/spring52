package com.loggar.resource.classpath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class ResourceFromResourceLoader {
	@Autowired ResourceLoader resourceLoader;

	public Resource loadEmployees() {
		return resourceLoader.getResource("classpath:data/employees.dat");
	}
}
