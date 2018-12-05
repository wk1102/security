package com.security.learn.config.validate;

import com.security.learn.config.validate.imageCode.ImageCodeProperties;

/**
 * 验证码的配置文件
 * @author issuser
 *
 */
public class ValidateCodeProperties {
	//图片码的 属性配置类
	private ImageCodeProperties image = new ImageCodeProperties();
	

	

	public ImageCodeProperties getImage() {
		return image;
	}

	public void setImage(ImageCodeProperties image) {
		this.image = image;
	}
	
	
}
