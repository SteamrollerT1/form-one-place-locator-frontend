package com.dsw.formoneplaceallocator.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;


@EnableAutoConfiguration
@Configuration
@Import(SecurityConfig.class)
@ComponentScan(basePackages = {
        "com.dsw.formoneplaceallocator.configs",
        "com.dsw.formoneplaceallocator.services",
        "com.dsw.formoneplaceallocator.controllers"})
public class MainConfig {

    @Value("${back.username}")
    private String backApiUser;

    @Value("${back.password}")
    private String backPassword;

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .basicAuthentication(backApiUser, backPassword)
                .build();
    }
}
