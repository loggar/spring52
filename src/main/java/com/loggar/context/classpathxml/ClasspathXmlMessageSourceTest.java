package com.loggar.context.classpathxml;

import java.util.List;
import java.util.Locale;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.loggar.context.beans.Course;
import com.loggar.context.beans.Teacher;

/**
 * Via Spring <beans> XML
 * 
 */
public class ClasspathXmlMessageSourceTest {

	@Test
	public void testInternationalization() {
		@SuppressWarnings("resource") MessageSource resources = new ClassPathXmlApplicationContext("com/loggar/context/xml/classpathxmlapplicationcontext-internationalization.xml");

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
		@SuppressWarnings("resource") ApplicationContext context = new ClassPathXmlApplicationContext("com/loggar/context/xml/classpathxmlapplicationcontext-example.xml");
		Teacher teacher = context.getBean("teacher", Teacher.class);
		List<Course> courses = teacher.getCourses();
		MatcherAssert.assertThat(courses.size(), CoreMatchers.equalTo(1));
		MatcherAssert.assertThat(courses.get(0).getName(), CoreMatchers.equalTo("math"));
	}
}
