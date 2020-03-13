package com.loggar.resource.classpath;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

public class ResourcePathFromValue {
	@Value("classpath:data/resource-data.txt") Resource resourceFile;
}
