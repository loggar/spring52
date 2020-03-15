package com.loggar.annotation.value.ex;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DBSampleApp {
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.loggar.value.example");
		context.refresh();
		System.out.println("Refreshing the spring context");
		DBConnection dbConnection = context.getBean(DBConnection.class);

		dbConnection.printDBConfigs();

		context.close();
	}
}
