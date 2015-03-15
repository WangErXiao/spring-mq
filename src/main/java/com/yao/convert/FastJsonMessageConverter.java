package com.yao.convert;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.AbstractMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;

import java.io.UnsupportedEncodingException;

/**
 * Created by root on 15-3-15.
 */
public class FastJsonMessageConverter  extends AbstractMessageConverter {

    public static final String DEFAULT_CHARSET = "UTF-8";

    public FastJsonMessageConverter() {
        super();
    }

    @Override
    protected Message createMessage(Object o, MessageProperties messageProperties) {
        byte[] bytes = null;
        try {
            String jsonString = JSON.toJSONString(o);
            bytes = jsonString.getBytes(DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            throw new MessageConversionException(
                    "Failed to convert Message content", e);
        }
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        messageProperties.setContentEncoding(DEFAULT_CHARSET);
        if (bytes != null) {
            messageProperties.setContentLength(bytes.length);
        }
        return new Message(bytes, messageProperties);
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
            String json = "";
            try {
                json = new String(message.getBody(),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return json;
    }

}
