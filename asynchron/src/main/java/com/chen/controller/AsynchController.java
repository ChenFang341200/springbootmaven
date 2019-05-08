package com.chen.controller;

import com.chen.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.concurrent.Callable;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/6 15:29
 */
@Controller
public class AsynchController {


    @ResponseBody
    @RequestMapping("/async1")
    public Callable<String> async() {
        System.out.println("主线程开始。。。起床拉" + Thread.currentThread() + "===>" + new Timestamp(System.currentTimeMillis()));
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("副线程开始。。。好的 听见了" + Thread.currentThread() + "===>" + new Timestamp(System.currentTimeMillis()));
                Thread.sleep(2000);
                System.out.println("副线程结束。。。起床成功" + Thread.currentThread() + "===>" + new Timestamp(System.currentTimeMillis()));
                return "起床中";
            }
        };
        System.out.println("主线程结束。。。已经通知完了" + Thread.currentThread() + "===>" + new Timestamp(System.currentTimeMillis()));
    return callable;
    }



}
