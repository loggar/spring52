package com.loggar.annotation.inject;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.loggar.annotation.components.ArbitraryDependency;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = ApplicationContextTestInjectName.class)
public class FieldInjectByNameTest {
	@Inject @Named("yetAnotherFieldInjectDependency") private ArbitraryDependency yetAnotherFieldInjectDependency;

	@Test
	public void givenInjectQualifier_WhenSetOnField_ThenDependencyValid() {
		Assertions.assertNotNull(yetAnotherFieldInjectDependency);
		Assertions.assertEquals("Child_2 Arbitrary Dependency", yetAnotherFieldInjectDependency.toString());
	}
}
