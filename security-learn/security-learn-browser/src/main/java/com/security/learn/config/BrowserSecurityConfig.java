package com.security.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * security 的适配器
 * @ClassName Browserser
 * @Description ToDo
 * @Author Administrator
 * @Date 2018/12/2 20:52
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 注册security的密码加密的类
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    /**
     * 配置浏览器端的配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ///http.httpBasic()// 弹框形式登录的方式
        http.formLogin()//表单登录的配置方式
        .and()
        .authorizeRequests()//对请求的授权
        .anyRequest()//任意请求
        .authenticated();//必须经过身份认证

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }
}
