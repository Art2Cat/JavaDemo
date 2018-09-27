package com.art2cat.dev.redisdemo.message;

import com.art2cat.dev.redisdemo.model.RedisMsg;
import com.art2cat.dev.redisdemo.repository.MessageRepository;
import java.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;

/**
 * com.art2cat.dev.redisdemo.message
 *
 * @author rorschach
 * @date 7/4/18
 */

@Service
@Slf4j
public class MessageSubscriber implements MessageListener {

    private MessageRepository messageRepository;
    private GenericJackson2JsonRedisSerializer jsonRedisSerializer;

    @Override
    public void onMessage(final Message message, final byte[] pattern) {

        log.info("RedisMsg received: " + new String(message.getBody()));

        RedisMsg redisMsg1 = (RedisMsg) jsonRedisSerializer
            .deserialize(Base64.getDecoder().decode(message.getBody()));
        messageRepository.save(redisMsg1);
        log.info("saved message to db");
    }

    @Autowired
    public void setMessageRepository(
        MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Autowired
    public void setJsonRedisSerializer(
        GenericJackson2JsonRedisSerializer jsonRedisSerializer) {
        this.jsonRedisSerializer = jsonRedisSerializer;
    }
}
