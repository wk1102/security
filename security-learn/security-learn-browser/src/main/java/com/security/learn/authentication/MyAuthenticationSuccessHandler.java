package com.security.learn.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 登录成功后的处理
 * @author issuser
 *
 */
@Component("myAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private Logger log = Logger.getLogger(getClass());
	
    
    @Autowired
    private ObjectMapper objectMapper;
    /**
     * 登录成功后的处理
     */
    @Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
    	log.info("登录成功");
    	response.setContentType("application/json;charset-UTF-8");
    	response.getWriter().write(objectMapper.writeValueAsString(authentication));;
	}
}
