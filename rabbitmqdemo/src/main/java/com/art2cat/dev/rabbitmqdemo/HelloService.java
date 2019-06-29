package com.art2cat.dev.rabbitmqdemo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloService {

    public void sayHello(String name) {
        log.info("hello " + name);
    }
}
