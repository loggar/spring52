package com.loggar.resource.inject;

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
public class SetterResourceInjectionByNameTest {
	private File defaultFile;

	@Resource(name = "namedFile")
	protected void setDefaultFile(File defaultFile) {
		this.defaultFile = defaultFile;
	}

	@Test
	public void givenResourceAnnotation_WhenOnSetter_THEN_MUST_INJECT_Dependency() {
		Assertions.assertNotNull(defaultFile);
		Assertions.assertEquals("namedFile.txt", defaultFile.getName());
	}
}
