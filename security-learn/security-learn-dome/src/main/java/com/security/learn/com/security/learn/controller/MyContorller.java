package com.security.learn.com.security.learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
/**
 * Demo class
 *
 * @author keriezhang
 * @date 2016/10/31
 */
@RestController
public class MyContorller {

	@GetMapping("/get1")
	@ApiOperation(value="测试get")
	public String  get() {
		System.err.println("我是请求 get1");
		return "我是 myController";
	}
}
