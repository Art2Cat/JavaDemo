package com.art2cat.dev.rabbitmqdemo;

import com.art2cat.dev.rabbitmqdemo.entity.RabbitmqRequest;
import com.art2cat.dev.rabbitmqdemo.mapper.RabbitmqRequestMapper;
import com.art2cat.dev.rabbitmqdemo.service.BaseApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer extends BaseApiService {

    @Value("${queue.topicExchange}")
    private String topicExchange;

    @Value("${queue.directExchange}")
    private String directExchange;

    @Value("${queue.topicQueue}")
    private String topicQueue;

    @Value("${queue.directQueue}")
    private String directQueue;

    @Autowired
    private RabbitmqRequestMapper rabbitMqRequestMapper;

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

    public void sendMessage(String type, String remark, Object params) {
        var rabbitMqRequest = new RabbitmqRequest();
        rabbitMqRequest.setRabbitmqType(type);
        rabbitMqRequest.setRabbitmqRemark(remark);
        rabbitMqRequest.setRabbitmqContext(serialize(params).orElse(null));
        rabbitMqRequestMapper.insert(rabbitMqRequest);
        serialize(rabbitMqRequest).ifPresent(this::sendTopicMessage);
    }
}
