package com.security.learn.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 自定义异常处理类
 * @author issuser
 *
 */
@ControllerAdvice
public class ControllerExceptionHandler {
	private  Logger log =  LoggerFactory.getLogger(getClass());
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Map<String,Object> controllerException(RuntimeException ex){
		
		log.info("进入异常类");
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("message",ex.getMessage());
		
		return resultMap;
		
	}
	

}
