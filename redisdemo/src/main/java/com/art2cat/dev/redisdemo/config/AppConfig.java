package com.art2cat.dev.redisdemo.config;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

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
    public GenericToStringSerializer<Object> genericToStringSerializer() {
        return new GenericToStringSerializer<>(Object.class);
    }

    @Bean
    public GenericJackson2JsonRedisSerializer jsonRedisSerializer() {
        return new GenericJackson2JsonRedisSerializer();
    }

    @Bean
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(
        JedisConnectionFactory jedisConnectionFactory) {
        final RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(genericToStringSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(jsonRedisSerializer());
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
    @Autowired
    public MessageListenerAdapter messageListenerAdapter(MessageListener messageListener) {
        return new MessageListenerAdapter(messageListener);
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(
        JedisConnectionFactory jedisCon, MessageListenerAdapter messageListenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(jedisCon);
        container.addMessageListener(messageListenerAdapter, topic());
        return container;
    }

    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
            .entryTtl(Duration.ofSeconds(600))
            .disableCachingNullValues();
        return cacheConfig;
    }

    @SuppressWarnings("rawtypes")
    @Bean
    public CacheManager cacheManager(JedisConnectionFactory jedisConnectionFactory) {
        RedisCacheManager rcm = RedisCacheManager.builder(jedisConnectionFactory)
            .cacheDefaults(cacheConfiguration()).transactionAware().build();
        return rcm;
    }
}
