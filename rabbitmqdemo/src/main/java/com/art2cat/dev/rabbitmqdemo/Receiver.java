package com.art2cat.dev.rabbitmqdemo;

import com.art2cat.dev.rabbitmqdemo.entity.RabbitmqRequest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Receiver extends BaseApiService {

    @Autowired
    private HelloService helloService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${queue.topicQueue}", durable = "true"),
            exchange = @Exchange(value = "${queue.topicExchange}", type = ExchangeTypes.TOPIC, durable = "true"),
            key = "topic#key"
    ))
    public void receiveTopicMessage(String message) {
        log.info("Received <" + message + ">");

        try {
            var requestOp = deserialize(message, RabbitmqRequest.class);
            Class<?> clazz = this.getClass();
            if (requestOp.isPresent()) {
                var request = (RabbitmqRequest) requestOp.get();
                Method method = clazz
                        .getDeclaredMethod(request.getRabbitmqType(), RabbitmqRequest.class);
                method.invoke(this, request);
            }

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            log.error(e.getMessage());
        }
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${queue.directQueue}", durable = "true"),
            exchange = @Exchange(value = "${queue.directExchange}", type = ExchangeTypes.DIRECT, durable = "true"),
            key = "direct#key"
    ))
    public void receiveDirectMessage(String message) {
        log.info("Received <" + message + ">");
    }

    public void sayHello(RabbitmqRequest request) {
        helloService.sayHello(request.getRabbitmqContext());
    }
}
