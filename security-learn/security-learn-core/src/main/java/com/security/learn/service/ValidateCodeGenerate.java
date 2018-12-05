package com.security.learn.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.security.learn.config.validate.code.ImageCode;

/**
 * 生成图片验证码接口
 * @author issuser
 *
 */
public interface ValidateCodeGenerate {

	/**
	 * 生产图片验证码的方法
	 * @param request
	 */
	ImageCode createImageCode(HttpServletRequest request);
}
