package com.sp.sp.service;

import com.sp.sp.entity.RebbitMqEntity;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class MessageSenderService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void send(RebbitMqEntity rebbitMqEntity){
        rabbitTemplate.convertAndSend("hugo-topic",rebbitMqEntity);
    }

}
