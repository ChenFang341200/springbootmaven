package com.chen.service;

import com.chen.bean.Employee;
import com.chen.mapper.EmployeeMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/8 16:36
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    /*
        将方法的运行结果进行缓存
        cacheNames/value:指定缓存组件的名字
        key：缓存数据使用的key
        keyGenerator:key的生成器 可以自己定义key的生成器组件的id
        key/keyGenerator ：二选一使用
        condition:指定符合条件的情况才缓存
            condition = "#a0>0"   第一个参数的值>0的时候才缓存 或者"#id>0"

         unless:否定缓存  当指定条件为true就不缓存
                unless = "result == null"
     */

    //@Cacheable(value = "Emp",keyGenerator = "MykeyGenerator",condition = "#id>0")
    @Cacheable(value = "Emp")
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"员工号");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    @CachePut(value = "Emp",key = "#employee.id")
    public Employee updateEmp(Employee employee){
        System.out.println("updateEmp"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }
}
