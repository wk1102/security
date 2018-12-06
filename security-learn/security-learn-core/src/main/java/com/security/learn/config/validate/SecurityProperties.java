package com.security.learn.config.validate;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "my.validate")
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityProperties {
	
	//验证码的配置类
	private ValidateCodeProperties code = new ValidateCodeProperties();
	//记住我功能的配置
    private BrowserProperties borwser = new BrowserProperties();
    
	public BrowserProperties getBorwser() {
		return borwser;
	}

	public void setBorwser(BrowserProperties borwser) {
		this.borwser = borwser;
	}

	public ValidateCodeProperties getCode() {
		return code;
	}

	public void setCode(ValidateCodeProperties code) {
		this.code = code;
	}

}
