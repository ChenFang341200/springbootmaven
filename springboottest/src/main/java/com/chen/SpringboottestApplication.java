package com.chen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import javax.xml.ws.Service;

//@ImportResource(locations = {"classpath:beans.xml"})  //导入Spring的配置文件，让配置文件里面的内容生效；
@SpringBootApplication
//@ComponentScan(basePackages = "com.chen.*",excludeFilters = {@ComponentScan.Filter(Service.class)})   //表示会扫描该路径下所有  除。。之外
public class SpringboottestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringboottestApplication.class, args);
    }

}
