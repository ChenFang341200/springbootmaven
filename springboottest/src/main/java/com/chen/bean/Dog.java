package com.chen.bean;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/*
       PropertySource(value = {"classpath:dog.properties"})
       加载指定的配置文件
 */
@Component
@PropertySource(value = {"classpath:dog.properties"})
@Data
public class Dog {
    private  String Name;
    private int age;
}
