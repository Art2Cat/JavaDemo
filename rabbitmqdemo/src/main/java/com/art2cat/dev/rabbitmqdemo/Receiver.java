package com.art2cat.dev.rabbitmqdemo;

import com.alibaba.druid.support.json.JSONUtils;
import com.art2cat.dev.rabbitmqdemo.entity.RabbitMqRequest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${queue.topicQueue}", durable = "true"),
            exchange = @Exchange(value = "${queue.topicExchange}", type = ExchangeTypes.TOPIC, durable = "true"),
            key = "topic#key"
    ))
    public void receiveTopicMessage(String message) {

        var mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            var request = mapper.readValue(message, RabbitMqRequest.class);
            Class<?> clazz = Class.forName(request.getToClassName());
            Constructor constructor = clazz.getConstructor();
            var instance = constructor.newInstance();
            Method method = clazz.getMethod(request.getMethodName(), String.class);

            method.invoke(instance, request.getParams());

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException | IOException e) {
            log.error(e.getMessage());
        }
        log.info("Received <" + message + ">");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${queue.directQueue}", durable = "true"),
            exchange = @Exchange(value = "${queue.directExchange}", type = ExchangeTypes.DIRECT, durable = "true"),
            key = "direct#key"
    ))
    public void receiveDirectMessage(String message) {
        log.info("Received <" + message + ">");
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
