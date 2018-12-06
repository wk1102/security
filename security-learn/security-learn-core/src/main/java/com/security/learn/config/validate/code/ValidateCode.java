package com.security.learn.config.validate.code;

import java.time.LocalDateTime;

/**
 * 短信验证码
 * @author issuser
 *
 */
public class ValidateCode {
	
	
	//code码
	private String code;
	
	//过期时间
	private LocalDateTime expireTime;

	
	public ValidateCode(String code, int expireTime) {
		super();
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireTime);
	}

	public ValidateCode(String code, LocalDateTime expireTime) {
		super();
		this.code = code;
		this.expireTime = expireTime;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public LocalDateTime getExpireTime() {
		return expireTime;
	}


	public void setExpireTime(LocalDateTime expireTime) {
		this.expireTime = expireTime;
	}

	
}
