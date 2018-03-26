package com.art2cat.dev.jpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * com.art2cat.dev.jpademo
 *
 * @author rorschach
 * @date 3/25/18
 */
@Configuration
@EnableAutoConfiguration
public class Applications extends SpringApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(Applications.class, args);
    }
}

