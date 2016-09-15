package com.kuaikanwang.image.controller.common;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
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
	
	
	/**
	 * 用给定的邮箱发送邮件--默认发送250封
	 * <p>Title: sendEmail</p>
	 * <p>Description: </p>
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/pic")
	@ResponseBody
	public String sendEmail(String username,String password){
		Long start = redisDaoImpl.getValueByKeyNum(RedisKeyUtil.getSendEmailStartValue());
		Long num = 0l;
		if(StringUtils.isNotBlank(username)&&StringUtils.isNotBlank(password)){
			num=sendEmailServiceImpl.sendEmail(start,username,password);
		}
		return "start is :"+start +" send num is :"+ num;
	}
	
}
