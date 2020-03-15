package com.loggar.annotation.composing;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.loggar.config.beans.MyDatabaseSession;

public class ConfigComposingImportTest {
	@Test
	public void myDatabaseSession() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(ConfigComposingImport.class);
		ctx.refresh();
		MyDatabaseSession myDatabaseSession = ctx.getBean(MyDatabaseSession.class);
		ctx.close();

		DataSource dataSource = myDatabaseSession.getDataSource();
		@SuppressWarnings("resource") BasicDataSource basicDataSource = (BasicDataSource) dataSource;

		Assertions.assertNotNull(myDatabaseSession);
		Assertions.assertTrue("localhost:00001".equals(basicDataSource.getUrl()));
	}
}
