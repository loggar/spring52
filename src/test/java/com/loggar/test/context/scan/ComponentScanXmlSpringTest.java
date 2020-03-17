package com.loggar.test.context.scan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// @RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "classpath:/com/loggar/test/context/scan/component.scan.config.xml" })
public class ComponentScanXmlSpringTest {
	@Autowired @Qualifier("ml") DataModelService ml;

	@Test
	public void test_ml_always_return_true() {
		Assertions.assertEquals(ml.getClass(), MachineLearningService.class);
		Assertions.assertTrue(ml.isValid(""));

	}
}
