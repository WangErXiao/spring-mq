package com.yao.convert;

import com.alibaba.fastjson.JSON;
import com.yao.model.Dog;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.AbstractJsonMessageConverter;
import org.springframework.amqp.support.converter.AbstractMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by root on 15-3-15.
 */
public class FastJsonMessageConverter  extends AbstractJsonMessageConverter {

    public static final String DEFAULT_CHARSET = "UTF-8";

    public FastJsonMessageConverter() {
        super();
    }

    @Override
    protected Message createMessage(Object o, MessageProperties messageProperties) {
        byte[] bytes = null;
        try {
            String jsonString = JSON.toJSONString(o);
            bytes = jsonString.getBytes(getDefaultCharset());
        }
        catch (IOException e) {
            throw new MessageConversionException("Failed to convert Message content to byte", e);
        }
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        messageProperties.setContentEncoding(getDefaultCharset());
//		messageProperties.setMessageId(UUID.randomUUID().toString());

        if (bytes != null) {
            messageProperties.setContentLength(bytes.length);
        }

        return new Message(bytes, messageProperties);
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        String json = "";
        com.yao.model.Message msg=new com.yao.model.Message();

        try {
            json = new String(message.getBody(),getDefaultCharset());
            msg.setId(message.getMessageProperties().getMessageId());
            msg.setBody(json);
        } catch (UnsupportedEncodingException e) {
            throw new MessageConversionException("Failed to convert Message content to json", e);
        }

        return msg;
    }


}
