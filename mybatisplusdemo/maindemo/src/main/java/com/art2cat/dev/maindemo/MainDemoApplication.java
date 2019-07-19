package com.art2cat.dev.maindemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan({"com.art2cat.dev.common", "com.art2cat.dev.maindemo"})
@MapperScan({"com.art2cat.dev.maindemo.*.mapper", "com.art2cat.dev.common.*.mapper"})
public class MainDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainDemoApplication.class, args);
    }

}
