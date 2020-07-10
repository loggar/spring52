package com.loggar.context.scan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.loggar.context.scan" })
public class ComponentScanConfig {

}
