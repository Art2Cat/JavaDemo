package com.art2cat.dev.rabbitmqdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloService {

    public void sayHello(String name) {
        log.info("hello " + name);
    }
}
