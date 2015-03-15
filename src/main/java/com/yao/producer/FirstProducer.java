package com.yao.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by root on 15-3-15.
 */
@Service("firstProducer")
public class FirstProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;
    public void sendDataToQueue(Object o){
        amqpTemplate.convertAndSend("q_test_key01",o);
    }
}
