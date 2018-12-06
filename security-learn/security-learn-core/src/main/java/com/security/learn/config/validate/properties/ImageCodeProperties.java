package com.security.learn.config.validate.properties;


/**
 * 图片验证码的配置属配置
 * @author issuser
 *
 */
public class ImageCodeProperties {
    //图片码宽度
	private int width = 67;
	//图片码高度
	private int heigth = 23;
	//图片码的长度
	private int length = 4;
	//过期时间
	private int expireInt = 60;
	//配置请求的路径,用于校验验证码
	private String url;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public int getHeigth() {
		return heigth;
	}
	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getExpireInt() {
		return expireInt;
	}
	public void setExpireInt(int expireInt) {
		this.expireInt = expireInt;
	}
	
}
