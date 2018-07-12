package com.art2cat.dev.redisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * com.art2cat.dev.redisdemo
 *
 * @author art2c
 * @date 7/3/2018
 */

@EnableAutoConfiguration
@SpringBootApplication
@EnableCaching
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
    
}
