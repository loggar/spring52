package com.loggar.annotation.value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.loggar.annotation.component.ComponentWithValue;

// @RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = ComponentWithValueConfig.class)
public class ComponentWithValueSpringTest {
	// autowired by type
	@Autowired private ComponentWithValue componentWithValue;

	@Test
	public void componentWithValue() {
		Assertions.assertNotNull(componentWithValue);
		Assertions.assertEquals(componentWithValue.getUrl(), "localhost:00001");
	}
}
