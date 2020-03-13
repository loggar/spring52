package com.loggar.value.example;

import org.springframework.beans.factory.annotation.Value;

public class ValueDefault {
	// Default Value
	@Value("Default DBConfiguration") private String defaultName;
	@Value("true") private boolean defaultBoolean;
	@Value("10") private int defaultInt;

	// Spring Environment Property
	@Value("${APP_NAME_NOT_FOUND}") private String defaultAppName;
	@Value("${APP_NAME_NOT_FOUND:Default}") private String defaultAppName2;

	// System Environment
	@Value("${java.home}") private String javaHome;
	@Value("${HOME}") private String homeDir;

	// SpEL
	@Value("#{systemProperties['java.home']}") private String javaHome2;

	// Spring @Value with methods
	@Value("Test")
	public void printValues(String s, String v) {
	} // both 's' and 'v' values will be 'Test'

	@Value("Test")
	public void printValues2(String s, @Value("Data") String v) {
	}
	// s=Test, v=Data
}
