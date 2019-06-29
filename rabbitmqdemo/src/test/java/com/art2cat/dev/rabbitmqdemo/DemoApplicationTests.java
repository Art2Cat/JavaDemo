package com.art2cat.dev.rabbitmqdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private Producer producer;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSendMessage() throws JsonProcessingException {
        if (producer != null) {
            producer.sendMessage("com.art2cat.dev.rabbitmqdemo.HelloService", "sayHello", "world");
        }
    }

    @Test
    public void testTopicMessage() {
        if (producer != null) {
            producer.sendTopicMessage("hello world");
            producer.sendDirectMessage("fuck world");
        }
    }

    @Test
    public void testSendTopicMessageByExchange() {
        if (producer != null) {
            producer.sendTopicMessageByExchange("Oh shit! it is work!");
        }
    }


}
