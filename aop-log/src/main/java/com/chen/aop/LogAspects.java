package com.chen.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/6 10:17
 */

/*
        日志切面类
 */
@Aspect
public class LogAspects {
    //抽取公共的切入点表达式
    //1、本类引用
    //2、其他切面引用
    //@Pointcut
    @Pointcut("execution(public int com.chen.aop.MathCalculator.*(..))")
    public void pointCut(){};

    //@Before("public int com.chen.aop.MathCalculator.mat(int,int)")
    //@Before("public int com.chen.aop.MathCalculator.*(..)")
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
       Object[] args= joinPoint.getArgs();
        System.out.println("方法名："+joinPoint.getSignature().getName()+"运行 @Before:参数{"+ Arrays.asList(args)+"}");
    }

    @After("com.chen.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint){

        System.out.println("方法名："+joinPoint.getSignature().getName()+"结束");
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){

        System.out.println("方法名："+joinPoint.getSignature().getName()+"正常放回结果{"+result+"}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){

        System.out.println("方法名："+joinPoint.getSignature().getName()+"异常信息{"+exception+"}");
    }
}
