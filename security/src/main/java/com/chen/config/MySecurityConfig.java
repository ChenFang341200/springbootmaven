package com.chen.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * <huazhu>
 *
 * @Author: ChenChen
 * @Date: 2019/5/13 11:11
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // super.configure(http);
        //定制请求的授权规则
        http.authorizeRequests()   //配置权限
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //开启自动配置的登入功能，如果没有登入就会跳到登入页
        http.formLogin()
                .loginPage("/login").permitAll()
                .failureUrl("login")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password");
        //1、/login来到登入页
        //2、重定向到/login？error表示登入失败
        //3、更多详情规定

    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //super.configure(auth);

        auth.inMemoryAuthentication()
                .withUser("zhangsan").password("123456").roles("VIP1","VIP2")
                .and()
                .withUser("lisi").password("123456").roles("VIP2","VIP3");
    }
}
