package com.art2cat.dev.rabbitmqdemo;

import com.alibaba.druid.support.json.JSONUtils;
import com.art2cat.dev.rabbitmqdemo.entity.RabbitMqRequest;
import com.art2cat.dev.rabbitmqdemo.mapper.RabbitMqRequestMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mysql.cj.xdevapi.JsonArray;
import com.rabbitmq.tools.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer {

    @Value("${queue.topicExchange}")
    private String topicExchange;

    @Value("${queue.directExchange}")
    private String directExchange;

    @Value("${queue.topicQueue}")
    private String topicQueue;

    @Value("${queue.directQueue}")
    private String directQueue;

//    @Autowired
//    private RabbitMqRequestMapper rabbitMqRequestMapper;

    @Autowired
    private RabbitMessagingTemplate rabbitMessagingTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendTopicMessage(String message) {
        rabbitTemplate.convertAndSend(topicQueue, message);
    }

    public void sendDirectMessage(String message) {
        rabbitTemplate.convertAndSend(directQueue, message);
    }

    public void sendTopicMessageByExchange(String message) {
        rabbitTemplate.convertAndSend(topicExchange, "topic#key", message);
    }

    public void sendMessage(String className, String methodName, String params) {
        var rabbitMqRequest = new RabbitMqRequest();
        rabbitMqRequest.setFromClassName(this.getClass().getName());
        rabbitMqRequest.setToClassName(className);
        rabbitMqRequest.setMethodName(methodName);
        rabbitMqRequest.setParams(params);
//        rabbitMqRequestMapper.insert(rabbitMqRequest);
        var objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            var json = objectMapper.writeValueAsString(rabbitMqRequest);
            rabbitTemplate.convertAndSend(topicQueue, json);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }
}
