package com.security.learn.service;

import javax.servlet.http.HttpServletRequest;

import com.security.learn.config.validate.code.ValidateCode;

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
	ValidateCode createImageCode(HttpServletRequest request);
}
