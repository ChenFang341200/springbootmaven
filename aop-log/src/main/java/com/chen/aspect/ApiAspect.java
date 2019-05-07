package com.chen.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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
    public void before(JoinPoint joinPoint){
        this.timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(this.timestamp+" 方法名："+joinPoint.getSignature().getName()+" 开始");
    }
    /**
     * 方法后置处理
     * 无论是否异常都执行
     * */
    /*@After("pointCut()")
    public void after(){

    }*/

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){

        System.out.println("方法名："+joinPoint.getSignature().getName()+" 结束");
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){

        System.out.println("方法名："+joinPoint.getSignature().getName()+"正常返回结果{"+result+"}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){

        System.out.println("方法名："+joinPoint.getSignature().getName()+"异常信息{"+exception+"}");
    }

}
