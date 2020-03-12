package com.loggar.application.context;

import java.util.List;
import java.util.Locale;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.loggar.beans.Course;
import com.loggar.beans.Student;
import com.loggar.beans.Teacher;

/**
 * Via Spring <beans> XML
 * 
 */
public class ClasspathXmlApplicationContextIntegrationTest {
	@Test
	public void testBasicUsage() {
		@SuppressWarnings("resource") ApplicationContext context = new ClassPathXmlApplicationContext("classpathxmlapplicationcontext-example.xml");
		Student student = (Student) context.getBean("student");
		MatcherAssert.assertThat(student.getNo(), CoreMatchers.equalTo(15));
		MatcherAssert.assertThat(student.getName(), CoreMatchers.equalTo("Tom"));

		Student sameStudent = context.getBean("student", Student.class);// do not need cast class
		MatcherAssert.assertThat(sameStudent.getNo(), CoreMatchers.equalTo(15));
		MatcherAssert.assertThat(sameStudent.getName(), CoreMatchers.equalTo("Tom"));
	}

	@Test
	public void testRegisterShutdownHook() {
		@SuppressWarnings("resource") ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpathxmlapplicationcontext-example.xml");
		context.registerShutdownHook();
	}

	@Test
	public void testInternationalization() {
		@SuppressWarnings("resource") MessageSource resources = new ClassPathXmlApplicationContext("classpathxmlapplicationcontext-internationalization.xml");

		String enHello = resources.getMessage("hello", null, "Default", Locale.ENGLISH);
		String enYou = resources.getMessage("you", null, Locale.ENGLISH);
		String enThanks = resources.getMessage("thanks", new Object[] { enYou }, Locale.ENGLISH);
		MatcherAssert.assertThat(enHello, CoreMatchers.equalTo("hello"));
		MatcherAssert.assertThat(enThanks, CoreMatchers.equalTo("thank you"));

		String chHello = resources.getMessage("hello", null, "Default", Locale.SIMPLIFIED_CHINESE);
		String chYou = resources.getMessage("you", null, Locale.SIMPLIFIED_CHINESE);
		String chThanks = resources.getMessage("thanks", new Object[] { chYou }, Locale.SIMPLIFIED_CHINESE);

		MatcherAssert.assertThat(chHello, CoreMatchers.equalTo("你好"));
		MatcherAssert.assertThat(chYou, CoreMatchers.equalTo("你"));
		MatcherAssert.assertThat(chThanks, CoreMatchers.equalTo("谢谢你"));
	}

	@Test
	public void testApplicationContextAware() {
		@SuppressWarnings("resource") ApplicationContext context = new ClassPathXmlApplicationContext("classpathxmlapplicationcontext-example.xml");
		Teacher teacher = context.getBean("teacher", Teacher.class);
		List<Course> courses = teacher.getCourses();
		MatcherAssert.assertThat(courses.size(), CoreMatchers.equalTo(1));
		MatcherAssert.assertThat(courses.get(0).getName(), CoreMatchers.equalTo("math"));
	}
}
