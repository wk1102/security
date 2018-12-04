package com.security.learn.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.ServletRequestUtils;

import com.security.learn.config.SecurityProperties;
import com.security.learn.service.ValidateCodeGenerate;
import com.security.learn.validate.code.ImageCode;


public class ImageCodeGenerate implements ValidateCodeGenerate {
	
	private SecurityProperties securityProperties;
	
	/**
	 * 创建图片码图片
	 * @param request
	 * @return
	 */
	@Override
	public ImageCode createImageCode(HttpServletRequest request) {
		
		//先从请求中获取width,如果没有就读取配置文件中的数据
		int width = ServletRequestUtils.getIntParameter(request, "width",securityProperties.getCode().getImage().getWith());
		int height =ServletRequestUtils.getIntParameter(request, "heigth",securityProperties.getCode().getImage().getWith());
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		
		Random random = new Random();
		
		g.setColor(getRandColor(200,250));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Time New Roman",Font.ITALIC,20));
		g.setColor(getRandColor(160,200));
		
		for(int i = 0;i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		String sRand = "";
		//验证码的长度
		int codeLength = securityProperties.getCode().getImage().getLength();
		for(int i = 0;i < codeLength; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
			g.setColor(new Color(20 + random.nextInt(110),20 + random.nextInt(110),20 + random.nextInt(110)));
			g.drawString(rand, 13 * i + 6,16);
		}
		g.dispose();
		//验证码过期时间
		int outTime =  securityProperties.getCode().getImage().getExpireInt();
		return new ImageCode(image,sRand,outTime);
	}
	/**
	 * 生成暗色方法
	 * @param fc
	 * @param bc
	 * @return
	 */
	private Color getRandColor(int fc,int bc) {
		Random random =new Random();
		if(fc > 255) {
			fc =255;
		}
		if(bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r,g,b);
	}
	public SecurityProperties getSecurityProperties() {
		return securityProperties;
	}
	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}


}
