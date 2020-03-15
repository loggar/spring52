package com.loggar.resource.inject;

import java.io.File;

import javax.annotation.Resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = ApplicationContextTestResourceQualifier.class)
public class ResourceInjectionMatchByQualifierTest {
	@Resource @Qualifier("defaultFile") private File dependency1;

	@Resource @Qualifier("namedFile") private File dependency2;

	@Test
	public void givenResourceAnnotation_WhenField_ThenDependency1Valid() {
		Assertions.assertNotNull(dependency1);
		Assertions.assertEquals("defaultFile.txt", dependency1.getName());
	}

	@Test
	public void givenResourceQualifier_WhenField_ThenDependency2Valid() {
		Assertions.assertNotNull(dependency2);
		Assertions.assertEquals("namedFile.txt", dependency2.getName());
	}
}
