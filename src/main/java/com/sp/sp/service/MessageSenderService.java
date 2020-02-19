package com.sp.sp.service;

import com.sp.sp.entity.RebbitMqEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
@Slf4j
@RabbitListener(queues = "hugo-topic")
public class MessageSenderService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void send(RebbitMqEntity rebbitMqEntity){
        rabbitTemplate.convertAndSend("hugo-topic",rebbitMqEntity);
    }
    /**
     * 消费者
    * */
    @RabbitHandler
    public void process(RebbitMqEntity rebbitMqEntity){
        System.out.println("111111111111");
        log.info(rebbitMqEntity.toString());
    }
}
