package com.chen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//
//@EnableEurekaClient
//@EnableDiscoveryClient //开启服务发现客户端
@SpringBootApplication(scanBasePackages = {"com.chen.*"})
public class JdbcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcDemoApplication.class, args);
    }

}
