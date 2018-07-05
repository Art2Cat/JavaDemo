package com.art2cat.dev.redisdemo.message;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
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
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSubscriber.class);
    private static List<String> MESSAGE_LIST = new ArrayList<String>();
    
    public static List<String> getMessageList() {
        return MESSAGE_LIST;
    }
    
    @Override
    public void onMessage(final Message message, final byte[] pattern) {
        MESSAGE_LIST.add(message.toString());
        log.info("Message received: " + new String(message.getBody()));
    }
}
