package com.loggar.test.context.scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.loggar.test.context.scan" })
public class ComponentScanConfig {

}
