package com.security.learn.controller;


import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.ServletWebRequest;

import com.security.learn.config.validate.code.ImageCode;
import com.security.learn.service.ValidateCodeGenerate;


@Controller
public class ValidateCodeController {
	private static final String SESSION_KEY ="SESSION_KEY_IMAGE_CODE";
	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	
	//注入图片验证码生成的类
	@Autowired
	private ValidateCodeGenerate imageCodeGenerate;
	
	@GetMapping("/code/image")
	public void createCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
        ImageCode imageCode = (ImageCode) imageCodeGenerate.createImageCode(request);
		sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode.getCode());
		ImageIO.write(imageCode.getImage(),"JPEG",response.getOutputStream());
	}
	

}
