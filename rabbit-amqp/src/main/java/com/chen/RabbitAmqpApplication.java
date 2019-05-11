package com.chen;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
        自动配置
        RabbitAutoConfiguration
        连接工厂ConnectionFactory
        RabbitProperties 封装RabbitMQ的配置
        RabbitTemplate 给RabbitMQ发送和接收消息
        AmqpAdmin  RabbitMQ系统管理功能组件
 */

@EnableRabbit   //开启MQ注解
@SpringBootApplication
public class RabbitAmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitAmqpApplication.class, args);
    }

}
