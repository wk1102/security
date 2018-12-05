package com.security.learn.config.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * 生成图形验证工具类
 * @author issuser
 *
 */
public class ImageCode {
	
	
	/**
	 *  构造函数
	 * @param image
	 * @param code
	 * @param expireIn 过期的时间
	 */
	public ImageCode(BufferedImage image, String code, int expireIn) {
		this.image = image;
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
	}

	
	public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
		this.image = image;
		this.code = code;
		this.expireTime = expireTime;
	}

	//图片
	private BufferedImage image;
	
	//code码
	private String code;
	
	//过期时间
	private LocalDateTime expireTime;

	public BufferedImage getImage() {
		return image;
	}


	public void setImage(BufferedImage image) {
		this.image = image;
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
