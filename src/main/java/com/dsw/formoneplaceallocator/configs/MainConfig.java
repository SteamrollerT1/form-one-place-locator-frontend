package com.dsw.formoneplaceallocator.configs;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@EnableAutoConfiguration
@Configuration
@Import(SecurityConfig.class)
@ComponentScan(basePackages = {
        "com.dsw.formoneplaceallocator.configs",
        "com.dsw.formoneplaceallocator.services",
        "com.dsw.formoneplaceallocator.controllers"})
public class MainConfig {


}
