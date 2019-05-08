package com.chen.controller;

import com.chen.aspect.ApiMonitor;
import com.chen.bean.Student;
import com.chen.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/7 14:22
 */
@RequestMapping("/mapper")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiMonitor
    @RequestMapping("/cha")
    public String chaStudent(){
     Student student= studentService.seletByNumber(1);
        System.out.println(student.toString());

        student=studentService.seletByAge(22);
        System.out.println(student.toString());
        return "success";
    }
}
