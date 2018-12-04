package com.security.learn.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * 登录失败的处理器
 * @author issuser
 *
 */
@Component("myAuthenticationFailuerHandler")
public class MyAuthenticationFailuerHandler implements AuthenticationFailureHandler {
	
	private Logger log = Logger.getLogger(getClass());
	
	@Autowired
	private ObjectMapper objectMapper;
    /*
     * 处理登录失败逻辑(non-Javadoc)
     * @see org.springframework.security.web.authentication.AuthenticationFailureHandler#onAuthenticationFailure(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.AuthenticationException)
     */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("登录失败");
		response.setContentType("application/json;charset=UTF-8");
		log.info(objectMapper.writeValueAsString(exception));
		response.getWriter().write(objectMapper.writeValueAsString(exception));
	}

}
