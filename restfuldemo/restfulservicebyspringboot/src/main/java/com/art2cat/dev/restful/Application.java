package com.art2cat.dev.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * com.art2cat.dev.restful
 *
 * @author Rorschach
 * @date 11/01/2018
 */

@Configuration
@SpringBootConfiguration
@EnableAutoConfiguration
@SpringBootApplication
public class Application extends WebMvcContext {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
