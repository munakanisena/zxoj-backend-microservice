package com.katomegumi.zxojbackendjudgeservice.rabbitMq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : 惠
 * @description : 初始化 队列和交换机
 * @createDate : 2025/5/1 下午11:56
 */
@Slf4j
public class InitRabbitMq {

    public static void doInit(){
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            String EXCHANGE_NAME = "code_exchange";
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");

            // 创建队列，随机分配一个队列名称
            String queueName = "code_queue";
            channel.queueDeclare(queueName, true, false, false, null);
            channel.queueBind(queueName, EXCHANGE_NAME, "my_routingKey");
        } catch (Exception e) {
            log.error("初始化队列和交换机失败", e);
        }
    }
}

