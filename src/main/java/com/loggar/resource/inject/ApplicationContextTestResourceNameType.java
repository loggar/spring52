package com.loggar.resource.inject;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContextTestResourceNameType {
	@Bean(name = "namedFile")
	public File namedFile() throws URISyntaxException {
		URL url = getClass().getResource("/data/namedFile.txt");
		return new File(url.getFile());
	}
}
