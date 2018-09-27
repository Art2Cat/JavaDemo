package com.art2cat.dev.redisdemo.message;

import com.art2cat.dev.redisdemo.model.RedisMsg;
import java.util.Base64;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;

/**
 * com.art2cat.dev.redisdemo.message
 *
 * @author rorschach
 * @date 7/4/18
 */
@Service
public class MessagePublisherImpl implements IMessagePublisher {

    private RedisTemplate<String, Object> redisTemplate;
    private ChannelTopic topic;
    private GenericJackson2JsonRedisSerializer jsonRedisSerializer;

    public MessagePublisherImpl() {
    }


    @Override
    public void publish(final String message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }

    @Override
    public void publishRedisMsg(final RedisMsg redisMsg) {
        if (Objects.nonNull(redisMsg) && Objects.nonNull(redisMsg.getContent())
            && Objects.nonNull(redisMsg.getSender())) {
            String msg = Base64.getEncoder().encodeToString(
                Objects.requireNonNull(jsonRedisSerializer.serialize(redisMsg)));
            publish(msg);
        }
    }

    @Autowired
    public void setRedisTemplate(
        RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Autowired
    public void setTopic(ChannelTopic topic) {
        this.topic = topic;
    }

    @Autowired
    public void setJsonRedisSerializer(
        GenericJackson2JsonRedisSerializer jsonRedisSerializer) {
        this.jsonRedisSerializer = jsonRedisSerializer;
    }
}
