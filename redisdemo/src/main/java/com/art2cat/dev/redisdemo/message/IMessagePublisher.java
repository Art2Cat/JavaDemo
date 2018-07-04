package com.art2cat.dev.redisdemo.message;

/**
 * com.art2cat.dev.redisdemo.message
 *
 * @author rorschach
 * @date 7/4/18
 */
public interface IMessagePublisher {
    
    void publish(final String message);
}
