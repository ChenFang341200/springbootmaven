package com.chen;

import com.chen.bean.Employee;
import com.chen.mapper.EmployeeMapper;
import com.chen.utils.FastJsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemoApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作k-v字符串
    @Autowired
    RedisTemplate redisTemplate;  //k-v都是对象
/*
    Redis常见的五大数据类型
    String、List、Set(集合)、Hash(散列)、ZSet(有序集合)
    stringRedisTemplate.opsForValue()
    stringRedisTemplate.opsForList()

 */
    @Test
    public void contextLoads() {
       // stringRedisTemplate.opsForValue().append("msg","word");
       String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);


        Employee employee = employeeMapper.getEmpById(1);
        String dataJson = FastJsonUtils.toJSONString(employee);
        stringRedisTemplate.opsForValue().set("employee",dataJson);
    }

}
