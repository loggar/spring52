package com.loggar.annotation.composing;

import java.io.InputStream;
import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.loggar.annotation.beans.MyDatabaseSession;

@Configuration
public class ConfigcomposingNestedConfiguration {
	@Inject DataSource dataSource; // from nested @Configuration

	@Configuration
	static class DatabaseConfig {
		@Bean
		DataSource dataSource() throws Exception {
			Properties _props = new Properties();
			Resource resource = new ClassPathResource("datasource.dbcp.dev.properties");
			InputStream _in = resource.getInputStream();
			if (_in != null) {
				_props.load(_in);
			}
			return (BasicDataSource) BasicDataSourceFactory.createDataSource(_props);
		}
	}

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
