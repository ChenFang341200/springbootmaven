package com.chen.service;

import com.chen.bean.Student;
import com.chen.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/7 14:20
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Student seletByNumber(int number) {

        return studentMapper.seletByNumber(number);
    }

    @Override
    public Student seletByAge(int age) {
        return studentMapper.seletByAge(age);
    }
}
