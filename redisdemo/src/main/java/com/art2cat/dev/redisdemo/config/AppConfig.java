package com.art2cat.dev.redisdemo.config;

import com.art2cat.dev.redisdemo.message.IMessagePublisher;
import com.art2cat.dev.redisdemo.message.MessagePublisherImpl;
import com.art2cat.dev.redisdemo.message.MessageSubscriber;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
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
@ComponentScan("com.art2cat.dev.redisdemo")
public class AppConfig {
    
    @Bean
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        final RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
        return template;
    }
    
    @Bean
    @ConditionalOnMissingBean(StringRedisTemplate.class)
    public StringRedisTemplate stringRedisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        return new StringRedisTemplate(jedisConnectionFactory);
    }
    
    @Bean
    public ChannelTopic topic() {
        return new ChannelTopic("pubsub:queue");
    }
    
    @Bean
    public IMessagePublisher redisPublisher(RedisTemplate<String, Object> redisTemplate) {
        return new MessagePublisherImpl(redisTemplate, topic());
    }
    
    @Bean
    public MessageListenerAdapter messageListener() {
        return new MessageListenerAdapter(new MessageSubscriber());
    }
    
    @SuppressWarnings("rawtypes")
    @Bean
    public CacheManager cacheManager(JedisConnectionFactory jedisConnectionFactory) {
        RedisCacheManager rcm = RedisCacheManager.create(jedisConnectionFactory);
        return rcm;
    }
}
