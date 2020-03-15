package com.loggar.annotation.composing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.loggar.annotation.beans.MyDatabaseSession;

@Configuration
@Import(DatabaseConfig.class)
public class ConfigComposingImport {
	private final DatabaseConfig dataConfig;

	public ConfigComposingImport(DatabaseConfig dataConfig) {
		this.dataConfig = dataConfig;
	}

	@Bean
	public MyDatabaseSession myDatabaseSession() {
		// reference the dataSource() bean method
		try {
			return new MyDatabaseSession(dataConfig.dataSource());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
