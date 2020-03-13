package com.loggar.resource.field;

import java.io.File;

import javax.annotation.Resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = ApplicationContextTestResourceNameType.class)
public class FieldResourceInjectionIntegrationTest {

	@Resource(name = "namedFile") private File defaultFile;

	@Test
	public void givenResourceAnnotation_WhenOnField_ThenDependencyValid() {
		Assertions.assertNotNull(defaultFile);
		Assertions.assertEquals("namedFile.txt", defaultFile.getName());
	}
}
