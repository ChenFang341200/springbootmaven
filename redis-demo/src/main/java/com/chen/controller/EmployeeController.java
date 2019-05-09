package com.chen.controller;

import com.chen.bean.Employee;
import com.chen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/8 16:39
 */
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/surchEmp/{id}")
    public Employee surchEmp(@PathVariable("id") Integer id){
      Employee employee = employeeService.getEmp(id);
        return employee;
    }
    @GetMapping("/update")
    public Employee update(Employee employee){
        Employee employee1 = employeeService.updateEmp(employee);
        return employee1;
    }
    @GetMapping("/emp/lastname/{lastName}")
    public Employee surchByName(@PathVariable("lastName") String lastName){
        Employee employees =employeeService.getEmpByName(lastName);
        return employees;
    }
}
