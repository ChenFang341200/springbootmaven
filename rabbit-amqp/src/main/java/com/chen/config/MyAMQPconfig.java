package com.chen.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/11 13:41
 */

    /*
        自己配置的消息转换工具 可以把消息以json格式传进MQ里
     */
@Configuration
public class MyAMQPconfig {

    @Bean
    public MessageConverter messageConverter(){
        return  new Jackson2JsonMessageConverter();
    }
}
