package com.loggar.config.beans;

import javax.sql.DataSource;

public class MyDatabaseSession {
	private DataSource dataSource;

	public MyDatabaseSession(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
