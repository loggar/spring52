package com.loggar.annotation.composing;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.loggar.annotation.beans.MyDatabaseSession;

@Configuration
@ImportResource("classpath:database-config.xml")
public class ConfigcomposingResource {
	@Inject DataSource dataSource; // from XML

	@Bean
	public MyDatabaseSession myDatabaseSession() {
		// reference the dataSource() bean method
		try {
			return new MyDatabaseSession(dataSource);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
