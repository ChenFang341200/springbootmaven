package com.chen.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/6 16:53
 */
@Service
public class AsyncServiceImpl implements AsyncService {
    @Override


    //@Scheduled(cron = "0 * * * * MON-SAT")  //每周六的的每分钟都运行一次  要了解cron表达式
    @Scheduled(fixedRate = 1000)  //延迟5秒
    @Async   //声名使用异步调用
    public void generateReport() throws InterruptedException {
        //打印异步线程名称
        System.out.println("报表线程名称： "+Thread.currentThread().getName());
        Thread.sleep(15000);
        System.out.println(Thread.currentThread().getName()+"结束");

    }




}
