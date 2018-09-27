package com.art2cat.dev.redisdemo.controller;

import com.art2cat.dev.redisdemo.message.IMessagePublisher;
import com.art2cat.dev.redisdemo.model.RedisMsg;
import com.art2cat.dev.redisdemo.repository.MessageRepository;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequestMapping(value = "/msg")
public class MessageController {

    @Qualifier("messagePublisherImpl")
    @Autowired
    private IMessagePublisher messagePublisher;

    @Autowired
    private MessageRepository messageRepository;


    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public String index(RedisMsg redisMsg, Model model) throws InterruptedException {

        if (Objects.nonNull(redisMsg) && Objects.nonNull(redisMsg.getContent())
            && Objects.nonNull(redisMsg.getSender())) {
            log.info(redisMsg.toString());
            messagePublisher.publishRedisMsg(redisMsg);
            // FIXME: stupid wait
            Thread.currentThread().join(1000);
        }

        model.addAttribute("messages", messageRepository.findAll());

        return "message";
    }
}
