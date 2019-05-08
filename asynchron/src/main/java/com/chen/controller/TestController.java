package com.chen.controller;

import com.chen.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/6 17:39
 */

/*
        和线程异步做比较
 */
@Controller
public class TestController {
    @Autowired
    private TestService testService;

    @ResponseBody
    @RequestMapping("/test")
    public String testCC() throws InterruptedException {
        System.out.println("请求线程名称： "+Thread.currentThread().getName());
        testService.print();
        return "tes";
    }


}
