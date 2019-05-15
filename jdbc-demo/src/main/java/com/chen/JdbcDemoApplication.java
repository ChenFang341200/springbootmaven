package com.chen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


//
@EnableEurekaClient
@EnableDiscoveryClient //开启服务发现客户端
@SpringBootApplication
public class JdbcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcDemoApplication.class, args);
    }

}
