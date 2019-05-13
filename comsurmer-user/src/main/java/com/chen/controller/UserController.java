package com.chen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/13 17:25
 */
@RestController
public class UserController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/buy")
    public String buyTiket(String name){
       String tiket =  restTemplate.getForObject("http://EURAKA-PROVADER/tiket",String.class);
        return name+"购买了："+tiket;
    }
}
