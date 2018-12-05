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

	public ValidateCodeProperties getCode() {
		return code;
	}

	public void setCode(ValidateCodeProperties code) {
		this.code = code;
	}

}
