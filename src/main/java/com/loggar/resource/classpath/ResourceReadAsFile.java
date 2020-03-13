package com.loggar.resource.classpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

public class ResourceReadAsFile {
	@Test
	public void whenResourceAsStream_thenReadSuccessful() throws IOException {
		InputStream resource = new ClassPathResource("data/employees.dat").getInputStream();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource))) {
			String employees = reader.lines().collect(Collectors.joining("\n"));

			Assertions.assertEquals("Joe Employee,Jan Employee,James T. Employee", employees);
		}
	}
}
