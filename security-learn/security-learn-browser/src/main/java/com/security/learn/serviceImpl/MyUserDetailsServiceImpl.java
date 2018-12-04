package com.security.learn.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



/**
 *  自定义用户储存认证
 * @ClassName MyUserDetailsServiceImpl
 * @Description ToDo
 * @Author Administrator
 * @Date 2018/12/2 21:34
 */
@Service
public class MyUserDetailsServiceImpl implements  UserDetailsService {
    private  final Logger log= LoggerFactory.getLogger(MyUserDetailsServiceImpl.class);
    //mapper数据库的方法注入

    /**
     * 注入密码加密类
     */
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("调用自定义用户存储认证的类");

        /**
         * 调用数据的查询方法
         */
        //调用密码加密方法{模拟从数据库取数据}
        String  password = passwordEncoder.encode("123456");
        return new User(username,password,AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
