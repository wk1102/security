package com.security.learn.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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


	@Autowired
	DataSource dataSource;
	@GetMapping("/get1")
	@ApiOperation(value="测试get")
	public String  get() throws SQLException {
		System.err.println("我是请求 get1");
		System.out.println(dataSource.getClass());
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		return "我是 myController";
	}
	
	
}
