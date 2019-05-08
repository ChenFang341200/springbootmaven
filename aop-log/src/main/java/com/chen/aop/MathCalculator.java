package com.chen.aop;

import org.springframework.stereotype.Component;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/6 10:15
 */

public class MathCalculator {
    public int mat(int i,int j){
        System.out.println("cccccccccccccccccccccccccccccc");
        return i/j;
    }
}
