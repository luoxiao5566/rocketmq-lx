package com.example.rocket.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Slf4j
public class RocketServiceListener {
    @Service
    @RocketMQMessageListener(consumerGroup = "consumer-group-2", topic = "demo",
            selectorExpression = "*", messageModel = MessageModel.BROADCASTING)
    public class Consumer implements RocketMQListener<String> {
        @Override
        public void onMessage(String message) {
            log.info("consumer1 rocket收到消息：{}", message);
        }
    }

    @Service
    @RocketMQMessageListener(consumerGroup = "consumer-group-1", topic = "demo",
            selectorExpression = "delay", messageModel = MessageModel.BROADCASTING)
    public class DelayConsumer implements RocketMQListener<String> {
        @Override
        public void onMessage(String message) {
            log.info("DelayConsumer rocket收到消息：{}", message);
        }
    }
}
