package com.loggar.context.classpathxml;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.loggar.context.beans.Student;

/**
 * Via Spring <beans> XML
 * 
 */
public class ClasspathXmlApplicationContextTest {
	@Test
	public void testBasicUsage() {
		@SuppressWarnings("resource") ApplicationContext context = new ClassPathXmlApplicationContext("com/loggar/context/xml/classpathxmlapplicationcontext-example.xml");
		Student student = (Student) context.getBean("student");
		MatcherAssert.assertThat(student.getNo(), CoreMatchers.equalTo(15));
		MatcherAssert.assertThat(student.getName(), CoreMatchers.equalTo("Tom"));

		Student sameStudent = context.getBean("student", Student.class);// do not need cast class
		MatcherAssert.assertThat(sameStudent.getNo(), CoreMatchers.equalTo(15));
		MatcherAssert.assertThat(sameStudent.getName(), CoreMatchers.equalTo("Tom"));
	}

	@Test
	public void testRegisterShutdownHook() {
		@SuppressWarnings("resource") ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("com/loggar/context/xml/classpathxmlapplicationcontext-example.xml");
		context.registerShutdownHook();
	}

}
