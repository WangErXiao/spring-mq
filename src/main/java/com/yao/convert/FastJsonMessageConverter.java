package com.yao.convert;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.AbstractMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;

/**
 * Created by root on 15-3-15.
 */
public class FastJsonMessageConverter  extends AbstractMessageConverter {


    @Override
    protected Message createMessage(Object o, MessageProperties messageProperties) {
        return null;
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {


        return null;
    }
}
