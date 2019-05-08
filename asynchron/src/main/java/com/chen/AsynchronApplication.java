package com.chen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//开启定时任务
@EnableScheduling
@SpringBootApplication
public class AsynchronApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsynchronApplication.class, args);
    }

}
