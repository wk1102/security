package com.security.learn.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.security.learn.config.validate.SecurityProperties;
import com.security.learn.service.ValidateCodeGenerate;
import com.security.learn.service.impl.ImageCodeGenerate;

/**
 * 图形码的注入类
 * @author issuser
 *
 */
@Configuration
public class ValidateCodeBeanConfig {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private SecurityProperties securityProperties ;

	@Bean
	@ConditionalOnMissingBean(name = "imageCodeGenerate" )
	public ValidateCodeGenerate imageCodeGenerator() {
		
		ImageCodeGenerate imageCodeGenerate = new ImageCodeGenerate();
		imageCodeGenerate.setSecurityProperties(securityProperties);
		return imageCodeGenerate;
    }
}
