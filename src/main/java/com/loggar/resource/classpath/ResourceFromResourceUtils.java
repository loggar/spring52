package com.loggar.resource.classpath;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.util.ResourceUtils;

public class ResourceFromResourceUtils {
	public File loadEmployeesWithSpringInternalClass() throws FileNotFoundException {
		return ResourceUtils.getFile("classpath:data/employees.dat");
	}
}
