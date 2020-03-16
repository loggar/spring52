package com.loggar.annotation.inject;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.loggar.annotation.component.ArbitraryDependency;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = ApplicationContextTestInjectType.class)
public class FieldInjectByTypeTest {
	@Inject private ArbitraryDependency fieldInjectDependency;

	@Test
	public void givenInjectAnnotation_WhenOnField_ThenValidDependency() {
		Assertions.assertNotNull(fieldInjectDependency);
		Assertions.assertEquals("Arbitrary Dependency", fieldInjectDependency.toString());
	}
}
