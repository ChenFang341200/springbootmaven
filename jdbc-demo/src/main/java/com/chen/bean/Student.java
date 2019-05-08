package com.chen.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/7 13:45
 */
@Data
public class Student implements Serializable {
    private int number;
    private String name;
    private int age;
}
