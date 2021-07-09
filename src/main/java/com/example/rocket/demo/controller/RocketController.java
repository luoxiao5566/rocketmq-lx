package com.example.rocket.demo.controller;

import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@RestController
public class RocketController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/rocket/send")
    public String rocketSend() {
        LocalDateTime currentTime = LocalDateTime.now();
        rocketMQTemplate.convertAndSend("demo",currentTime.toString());
        return  currentTime.toString();
    }

    @GetMapping("/rocket/delayMsg/send")
    public String rocketDelayMsgSend() {
        LocalDateTime currentTime = LocalDateTime.now();
        rocketMQTemplate.syncSend("demo:delay", MessageBuilder.withPayload(currentTime.toString()).build(),2000,2);
        return currentTime.toString();
    }

}
