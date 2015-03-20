package com.yao.exchange.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.UUID;

/**
 * Created by root on 15-3-20.
 */
public class LogTopic {
    private static final String EXCHANGE_NAME = "topic_logs";
    public static void main(String[] args) throws Exception {
        //创建连接和通道
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("yao");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        String[] routing_keys = new String[]{"kernal.info","cron.warning",
                "auth.info","kernel.critical"};
        for(String routing_key : routing_keys){
            String msg = UUID.randomUUID().toString();
            channel.basicPublish(EXCHANGE_NAME, routing_key, null, msg.getBytes());
            System.out.println(" [x] Sent routingKey = " + routing_key +
                    " ,msg = " + msg + ".");
        }
        channel.close();
        connection.close();
    }
}
