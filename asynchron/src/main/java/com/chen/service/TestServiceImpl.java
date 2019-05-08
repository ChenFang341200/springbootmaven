package com.chen.service;

import org.springframework.stereotype.Service;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/6 17:40
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public void print() throws InterruptedException {
        System.out.println("报表线程名称： "+Thread.currentThread().getName());
        Thread.sleep(5000);
    }
}
