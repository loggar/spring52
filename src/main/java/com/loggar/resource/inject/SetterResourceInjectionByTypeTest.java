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
public class SetterResourceInjectionByTypeTest {
	private File arbDependency;
	private File anotherArbDependency;

	@Resource
	@Qualifier("namedFile")
	public void setArbDependency(File arbDependency) {
		this.arbDependency = arbDependency;
	}

	@Resource
	@Qualifier("defaultFile")
	public void setAnotherArbDependency(File anotherArbDependency) {
		this.anotherArbDependency = anotherArbDependency;
	}

	@Test
	public void givenResourceQualifier_WhenSetter_ThenValidDependencies() {
		Assertions.assertNotNull(arbDependency);
		Assertions.assertEquals("namedFile.txt", arbDependency.getName());
		Assertions.assertNotNull(anotherArbDependency);
		Assertions.assertEquals("defaultFile.txt", anotherArbDependency.getName());
	}
}
