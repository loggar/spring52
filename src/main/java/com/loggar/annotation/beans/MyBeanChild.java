package com.loggar.annotation.beans;

public class MyBeanChild extends MyBean {
	public MyBeanChild() {
		super();
	}

	public MyBeanChild(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "MyBeanChild [name=" + this.name + "]";
	}
}
