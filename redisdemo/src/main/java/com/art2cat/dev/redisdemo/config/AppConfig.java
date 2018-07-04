package com.art2cat.dev.redisdemo.config;

import com.art2cat.dev.redisdemo.message.IMessagePublisher;
import com.art2cat.dev.redisdemo.message.MessagePublisherImpl;
import com.art2cat.dev.redisdemo.message.MessageSubscriber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

/**
 * com.art2cat.dev.redisdemo
 *
 * @author rorschach
 * @date 7/3/18
 */
@Configuration
public class AppConfig {
    
    @Bean
    private JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }
    
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
        return template;
    }
    
    @Bean
    public StringRedisTemplate stringRedisTemplate() {
        return new StringRedisTemplate(jedisConnectionFactory());
    }
    
    @Bean
    public ChannelTopic topic() {
        return new ChannelTopic("pubsub:queue");
    }
    
    @Bean
    public IMessagePublisher redisPublisher() {
        return new MessagePublisherImpl(redisTemplate(), topic());
    }
    
    @Bean
    public MessageListenerAdapter messageListener() {
        return new MessageListenerAdapter(new MessageSubscriber());
    }
}
