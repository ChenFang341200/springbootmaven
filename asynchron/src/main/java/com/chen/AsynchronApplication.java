package com.chen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//开启定时任务
@EnableScheduling
//@EnableAsync  //开启异步注解功能
@SpringBootApplication
public class AsynchronApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsynchronApplication.class, args);
    }

}
