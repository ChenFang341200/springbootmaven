package com.chen;

import com.chen.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitAmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpAdmin amqpAdmin;


    //发送
    @Test
    public void contextLoads() {
        //message需要自己构造 可定义消息体内容和消息头
        //rabbitTemplate.send(exchange,routeKey,message);

        //object默认当成消息体，只需要传入发送的对象，会自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routeKey,object);

        Map<String,Object> map = new HashMap<>();
        map.put("msg","测试2");
        map.put("data", Arrays.asList("hhhe",123,true,false));
        Book book =new Book();
        book.setAuto("陈晨");
        book.setName("西游记");
        rabbitTemplate.convertAndSend("exchange.fanout","chen.news",book);

    }
//接收
    @Test
    public void respons(){
     Object o =   rabbitTemplate.receiveAndConvert("chen.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    //创建删除
    @Test
    public void creatExchange(){
//        amqpAdmin.declareExchange(new DirectExchange("ampqadmin.exchage"));
//        System.out.println("交换创建成功");
//        amqpAdmin.declareExchange(new FanoutExchange("fanoutadmin.fanout"));

//        amqpAdmin.declareQueue(new Queue("amqpqueue.queue",true));
       // System.out.println("队列创建成功");
        amqpAdmin.declareBinding(new Binding("amqpqueue.queue",Binding.DestinationType.QUEUE,"ampqadmin.exchage","amq.hh",null));
        System.out.println("绑定成功");
    }


}
