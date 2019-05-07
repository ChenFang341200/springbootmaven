package com.chen.controller;

import com.chen.aspect.ApiMonitor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @ApiMonitor
    @RequestMapping("/hello")
    public String Hello(){
        return "hello";
    }
}
