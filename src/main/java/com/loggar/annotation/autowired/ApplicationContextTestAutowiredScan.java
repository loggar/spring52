package com.loggar.annotation.autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.loggar.annotation.components" })
public class ApplicationContextTestAutowiredScan {

}
