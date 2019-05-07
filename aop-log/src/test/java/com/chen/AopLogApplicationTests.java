package com.chen;

import com.chen.aop.MathCalculator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AopLogApplicationTests {

    @Autowired
    private MathCalculator mathCalculator;
    @Test
    public void testAspect(){
        mathCalculator.mat(1,1);

    }

    @Test
    public void contextLoads() {

        //日志级别
        //由低到高
        //可以调整日志级别
        log.trace("trace日志");
        log.debug("debug日志");
        log.info("info日志");
        log.warn("warn日志");
        log.error("error日志");

    }

}
