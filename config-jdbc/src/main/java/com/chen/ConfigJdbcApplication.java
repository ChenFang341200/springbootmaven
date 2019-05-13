package com.chen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//开启configServer服务
@EnableConfigServer
//@EnableEurekaClient
@EnableDiscoveryClient   //注解使项目具备 Eureka Client 功能
@SpringBootApplication
public class ConfigJdbcApplication<EnableEurekaClient> {

    public static void main(String[] args) {
        SpringApplication.run(ConfigJdbcApplication.class, args);
    }

}
