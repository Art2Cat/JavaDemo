package com.art2cat.dev.rabbitmqdemo;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    public final static String directQueueName = "com.art2cat.amqp-simple.direct.queue";
    public final static String directExchangeName = "com.art2cat.amqp-simple.direct.exchange";
    public final static String topicExchangeName = "com.art2cat.amqp-simple.topic.exchange";
    public final static String topicQueueName = "com.art2cat.amqp-simple.topic.queue";

//    @Bean
//    Queue queue() {
//        return new Queue(directQueueName, false);
//    }
//
//    @Bean
//    DirectExchange directExchange() {
//
//        return new DirectExchange(directExchangeName);
//    }
//
//    @Bean
//    TopicExchange exchange() {
//        return new TopicExchange(topicExchangeName);
//    }
//
//    @Bean
//    Binding binding(Queue queue, DirectExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with(directQueueName);
//    }
//
//    @Bean
//    Binding binding(Queue queue, TopicExchange topicExchange) {
//        return BindingBuilder.bind(queue).to(topicExchange).with(directQueueName);
//    }

//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
//            MessageListenerAdapter listenerAdapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(directQueueName, topicQueueName);
//        container.setMessageListener(listenerAdapter);
//        return container;
//    }

//    @Bean
//    MessageListenerAdapter listenerAdapter(Receiver receiver) {
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }


}
