package com.loggar.annotation.autowired;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.loggar.annotation.component.ArbitraryDependency;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = ApplicationContextTestAutowiredType.class)
public class FieldAutowireByTypeTest {
	@Autowired private ArbitraryDependency fieldDependency;

	@Test
	public void givenAutowired_WhenSetOnField_ThenDependencyResolved() {
		Assertions.assertNotNull(fieldDependency);
		Assertions.assertEquals("Arbitrary Dependency", fieldDependency.toString());
	}
}
