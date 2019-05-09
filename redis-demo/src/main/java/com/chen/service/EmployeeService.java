package com.chen.service;

import com.chen.bean.Employee;
import com.chen.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/8 16:36
 */

//默认的Cache缓存数据保存在ConcurrentMap
    //开发中使用缓存中间件：redis、memcached、ehcache

//@CacheConfig(cacheNames = "Emp")   抽取缓存得公共配置  可以代替下面得value
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
    //@Cacheable(value = "Emp")
    public Employee getEmp(Integer id){

        System.out.println("查询"+id+"员工号");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    /*
           更新缓存 key值必须一样
     */

    @CachePut(value = "Emp",key = "#employee.id")
    public Employee updateEmp(Employee employee){
        System.out.println("updateEmp"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /*
        清除缓存
        allEntries = true 指定清除这个缓存中所有数据
        beforeInvocation = false 是否在方法之前执行清除  默认是方法之后清楚
     */

    @CacheEvict(value = "Emp",allEntries = true)
    public void deleteEmp(Integer id){
        System.out.println("deletEmp");
        employeeMapper.deletEmpById(id);
    }


    /*
          @Caching定义复杂
     */
    @Caching(
            cacheable = {
                    @Cacheable(value = "Emp",key = "#lastName")
            },
            put = {
                    @CachePut(value = "Emp",key = "#result.id"),
                    @CachePut(value = "Emp",key = "#result.email")
            }
    )
    public Employee getEmpByName(String lastName){

        Employee employee = employeeMapper.getEmpByName(lastName);
        System.out.println(employee);
        return employee;
    }

}
