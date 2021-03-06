package com.loggar.annotation.composing;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class DatabaseConfig {
	@Bean
	public DataSource dataSource() throws Exception {
		Properties _props = new Properties();
		Resource resource = new ClassPathResource("datasource.dbcp.1.dev.properties");
		InputStream _in = resource.getInputStream();
		if (_in != null) {
			_props.load(_in);
		}
		return BasicDataSourceFactory.createDataSource(_props);
	}
}
