package com.yao.consumer;

import com.alibaba.fastjson.JSON;
import com.yao.model.Dog;
import com.yao.model.Message;
import org.springframework.stereotype.Service;

/**
 * Created by yaozb on 15-4-6.
 */
@Service
public class SecondConsumer implements NoticeConsume {
    @Override
    public void onMessage(Message message) {
        Dog dog= JSON.parseObject((String) message.getBody(), Dog.class);
        System.out.println(dog.getName()+" "+dog.getAge());
    }
}
