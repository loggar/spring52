package com.loggar.resource.classpath;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ResourceLoadManually {
	@Test
	public void classPathResource() {
		// from the default system classloader
		Resource employees = new ClassPathResource("data/employees.dat");
		Assertions.assertTrue(employees.exists());

		// from the thread's context classloader
		Resource employees2 = new ClassPathResource("data/employees.dat", this.getClass().getClassLoader());
		Assertions.assertTrue(employees2.exists());

		// indirectly through a specified class:
		Resource employees3 = new ClassPathResource("data/employees.dat", ResourceLoadManually.class.getClassLoader());
		Assertions.assertTrue(employees3.exists());
	}

}
