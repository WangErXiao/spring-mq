package com.yao.consumer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by root on 15-3-15.
 */
@Service("firstConsumer")
public class FirstConsumer {
    @Autowired
    private AmqpTemplate amqpTemplate;
    public Object getMsg(){
       return amqpTemplate.receiveAndConvert("q_test");
    }
}
