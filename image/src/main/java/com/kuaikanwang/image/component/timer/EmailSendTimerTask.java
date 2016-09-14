package com.kuaikanwang.image.component.timer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kuaikanwang.image.component.email.SendEmailService;
import com.kuaikanwang.image.redis.RedisDao;
import com.kuaikanwang.image.utils.redis.RedisKeyUtil;
/**
 * 邮件定时发送
 * <p>Title: EmailSendTimerTask.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年9月12日下午11:37:33
 * @version 1.0
 */
@Component
public class EmailSendTimerTask {

	@Resource
	private SendEmailService sendEmailServiceImpl;
	@Resource
	private RedisDao redisDaoImpl;

	public void work(){
		System.out.println("send mail start !");
		Long start = redisDaoImpl.getValueByKeyNum(RedisKeyUtil.getSendEmailStartValue());
		Long num = sendEmailServiceImpl.sendEmail(start);
		System.out.println("send emial num is : " + num + " and start is : " + start);
	}
	
	
}
