package com.loggar.resource.classpath;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

public class ResourceReadAsInputStream {
	@Test
	public void whenResourceAsFile_thenReadSuccessful() throws IOException {
		File resource = new ClassPathResource("data/employees.dat").getFile();
		String employees = new String(Files.readAllBytes(resource.toPath()));
		Assertions.assertEquals("Joe Employee,Jan Employee,James T. Employee", employees.trim());
	}
}
