package com.chen;

import com.chen.bean.Dog;
import com.chen.bean.Person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringboottestApplicationTests {
//    @Autowired
//    Person person;
    @Autowired
    Dog dog;

    @Autowired
    ApplicationContext ioc;
    @Test
    public void contextLoads() {
 //       System.out.println(person);
        System.out.println(dog);
    }
    @Test    //测试helloService是否注入
    public void testHelloService(){
           boolean b = ioc.containsBean("helloService02");
        System.out.println(b);
    }

}
