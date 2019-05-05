package com.chen.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/5 11:22
 */
/*
        @Aspect核心主键
 */
@Aspect
@Component
public class ApiAspect {
    private Timestamp timestamp;

    //定义切点
    @Pointcut("@annotation(com.chen.aspect.ApiMonitor)")
    public void pointCut(){

    }

    /**
     * 方法前置处理
     * 有无异常都执行
     * */
    @Before("pointCut()")
    public void before(){
        this.timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(this.timestamp);
    }
    /**
     * 方法后置处理
     * 无论是否异常都执行
     * */
    /*@After("pointCut()")
    public void after(){

    }*/



}
