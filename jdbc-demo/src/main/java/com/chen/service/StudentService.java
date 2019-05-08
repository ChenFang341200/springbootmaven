package com.chen.service;

import com.chen.bean.Student;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/7 14:18
 */
public interface StudentService {
    Student seletByNumber (int number);
    Student seletByAge (int age);
}
