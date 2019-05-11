package com.chen.service;

import com.chen.bean.Employee;
import com.chen.mapper.EmployeeMapper;
import com.chen.utils.FastJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.core.StringRedisTemplate;
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

    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作k-v字符串


    //@Cacheable(value = "Emp",keyGenerator = "MykeyGenerator",condition = "#id>0")
    //@Cacheable(value = "Emp")
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"员工号");
        Employee emp;
       boolean iemp = stringRedisTemplate.hasKey("Emp");
       if(iemp == false){
           emp = employeeMapper.getEmpById(id);
           String dataJson = FastJsonUtils.toJSONString(emp);
           stringRedisTemplate.opsForValue().set("Emp",dataJson);
       }else {
          String str = stringRedisTemplate.opsForValue().get("Emp");
          emp = FastJsonUtils.toBean(str,Employee.class);
       }
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
