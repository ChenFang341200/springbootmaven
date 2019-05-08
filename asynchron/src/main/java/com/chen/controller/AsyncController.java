package com.chen.controller;

import com.chen.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/6 17:06
 */

 /*
    线程异步
  */
@Controller
@RequestMapping("/async")
public class AsyncController {
    @Autowired
    private AsyncService asyncService;
    @ResponseBody
    @RequestMapping("/page")
    public  String AsyncPage() throws InterruptedException {
        System.out.println("请求线程名称： "+Thread.currentThread().getName());
        asyncService.generateReport();
        return "async555";
    }
}
