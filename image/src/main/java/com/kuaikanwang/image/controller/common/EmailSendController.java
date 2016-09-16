package com.kuaikanwang.image.controller.common;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaikanwang.image.component.email.SendEmailService;
import com.kuaikanwang.image.domain.bean.email.PicEmail;
import com.kuaikanwang.image.redis.RedisDao;
import com.kuaikanwang.image.utils.mail.SendmailUtil;
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
	
	/**
	 * 测试方法,用于测试
	 * 多帐号同IP是否可以发送邮件而不被限制
	 * 测试发送频域为多少合适
	 * 测试发送数目为多少合适
	 * <p>Title: sendEmailTest</p>
	 * <p>Description: </p>
	 * @param username 发送者帐号
	 * @param password	发送者密码
	 * @param to  发送给谁
	 * @param num 一次发送的数目
	 * @param frequency 大于此时间才能再次发送 默认 14400 ms 14.4s
	 * @return
	 */
	@RequestMapping("/test")
	@ResponseBody
	public String sendEmailTest(String username,String password,
			String to,@RequestParam(defaultValue="1")Integer num,
			@RequestParam(defaultValue="14400")Long frequency){
		String result="false";
		if(StringUtils.isNotBlank(username)&&StringUtils.isNotBlank(password)&&StringUtils.isNotBlank(to)){
				
				PicEmail picEmail = new PicEmail();
				picEmail.setPicUrl("http://www.2cto.com/meinv/uploads/allimg/160507/1-16050G44635-50.jpg ");
				for (int i = 0; i < num; i++) {
					//这里要防止发送太快了 14.4秒发送一封! 1小时 250封
				 try {
						long sendStart = System.currentTimeMillis();
						
						SendmailUtil sendmailUtil = new SendmailUtil(username,password);
						sendmailUtil.doSendHtmlEmail(picEmail.getHeadName(), picEmail,to);
						long sendEnd = System.currentTimeMillis();
						frequency =frequency -(sendEnd-sendStart);
						if(frequency>0){
							Thread.sleep(frequency);
						}
					} catch (UnsupportedEncodingException |MessagingException|InterruptedException e) {
						System.out.println("occur error is : "+ e);;
					} 
				}
				result ="success";
		}
		return result;
	}
	
}
