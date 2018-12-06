package com.security.learn.config.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * 生成图形验证工具类
 * @author issuser
 *
 */
public class ImageCode extends ValidateCode{
	//图片
    private BufferedImage image;
		
	
	/**
	 *  构造函数
	 * @param image
	 * @param code
	 * @param expireIn 过期的时间
	 */
	public ImageCode(BufferedImage image, String code, int expireIn) {
		super(code,expireIn);
		this.image = image;
		
	}
	
	public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
		super(code,expireTime);
		this.image = image;
	}
	

	public BufferedImage getImage() {
		return image;
	}


	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
