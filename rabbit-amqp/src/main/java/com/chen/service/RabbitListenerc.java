package com.chen.service;

import com.chen.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/11 13:55
 */
@Service
public class RabbitListenerc {



    @RabbitListener(queues ="chen.news")
    public void receive(Message message){
        System.out.println("消息体："+message.getBody());
        System.out.println("消息头："+message.getMessageProperties());
    }

    @RabbitListener(queues ="chen.emps")
    public void receive1(Book message){
        System.out.println("收到消息："+message);

    }


}
