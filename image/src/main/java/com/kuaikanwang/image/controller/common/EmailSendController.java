package com.kuaikanwang.image.controller.common;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaikanwang.image.component.email.SendEmailService;
import com.kuaikanwang.image.redis.RedisDao;
import com.kuaikanwang.image.redis.RedisDaoImpl;
import com.kuaikanwang.image.utils.redis.RedisKeyUtil;

@Controller
@RequestMapping("/email/send")
public class EmailSendController {

	@Resource
	private SendEmailService sendEmailServiceImpl;
	@Resource
	private RedisDao redisDaoImpl;
	
	
	@RequestMapping("/test")
	@ResponseBody
	public Long sendTest(){
		
		return sendEmailServiceImpl.sendEmail(0);
		
	}
	
	@RequestMapping("/pic")
	@ResponseBody
	public Long sendEmail(){
		Long start = redisDaoImpl.getValueByKeyNum(RedisKeyUtil.getSendEmailStartValue());
		System.out.println(start);
		Long num = sendEmailServiceImpl.sendEmail(start);
		return num;
	}
	
}
