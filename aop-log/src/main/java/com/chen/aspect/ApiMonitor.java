package com.chen.aspect;

import java.lang.annotation.*;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/5 11:22
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiMonitor {
}
