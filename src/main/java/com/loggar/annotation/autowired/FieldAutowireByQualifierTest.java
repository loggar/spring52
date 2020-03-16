package com.loggar.annotation.autowired;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.loggar.annotation.component.ArbitraryDependency;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = ApplicationContextTestAutowiredQualifier.class)
public class FieldAutowireByQualifierTest {
	@Autowired @Qualifier("autowiredFieldDependency") private ArbitraryDependency fieldDependency1;

	@Autowired @Qualifier("anotherAutowiredFieldDependency") private ArbitraryDependency fieldDependency2;

	@Test
	public void givenAutowiredQualifier_WhenOnField_ThenDep1Valid() {
		Assertions.assertNotNull(fieldDependency1);
		Assertions.assertEquals("Arbitrary Dependency", fieldDependency1.toString());
	}

	@Test
	public void givenAutowiredQualifier_WhenOnField_ThenDep2Valid() {
		Assertions.assertNotNull(fieldDependency2);
		Assertions.assertEquals("Child_1 Arbitrary Dependency", fieldDependency2.toString());
	}
}
