package com.dsw.formoneplaceallocator;

import com.dsw.formoneplaceallocator.configs.MainConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MainConfig.class)
public class FormOnePlaceAllocatorFrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormOnePlaceAllocatorFrontendApplication.class, args);
    }

}
