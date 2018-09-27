package com.art2cat.dev.redisdemo.message;

import com.art2cat.dev.redisdemo.model.RedisMsg;

/**
 * com.art2cat.dev.redisdemo.message
 *
 * @author rorschach
 * @date 7/4/18
 */
public interface IMessagePublisher {

    void publish(final String message);

    void publishRedisMsg(final RedisMsg redisMsg);
}
