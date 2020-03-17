package com.loggar.annotation.inject;

import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.loggar.annotation.components.ArbitraryDependency;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = ApplicationContextTestInjectQualifier.class)
public class FieldInjectByQualifierTest {
	@Inject @Qualifier("defaultFile") private ArbitraryDependency defaultDependency;

	@Inject @Qualifier("namedFile") private ArbitraryDependency namedDependency;

	@Test
	public void givenInjectQualifier_WhenOnField_ThenDefaultFileValid() {
		Assertions.assertNotNull(defaultDependency);
		Assertions.assertEquals("Arbitrary Dependency", defaultDependency.toString());
	}

	@Test
	public void givenInjectQualifier_WhenOnField_ThenNamedFileValid() {
		Assertions.assertNotNull(namedDependency);
		Assertions.assertEquals("Child_1 Arbitrary Dependency", namedDependency.toString());
	}
}
