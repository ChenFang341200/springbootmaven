package com.chen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }
    @RequestMapping("/success")
    public String Success(Map<String,Object> map){
        map.put("hello","你好");
       // int i =10/0;  已经捕获全局异常
        return "success";
    }

}
