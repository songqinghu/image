package com.kuaikanwang.image.component.email.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.component.email.SendEmailService;
import com.kuaikanwang.image.component.timer.SpiderTimerTask;
import com.kuaikanwang.image.dao.ImageAccessMapper;
import com.kuaikanwang.image.dao.MainEmailMapper;
import com.kuaikanwang.image.domain.bean.email.PicEmail;
import com.kuaikanwang.image.redis.RedisDao;
import com.kuaikanwang.image.utils.mail.SendmailUtil;
import com.kuaikanwang.image.utils.redis.RedisKeyUtil;
@Service
@Transactional
public class SendEmailServiceImpl implements SendEmailService{
	
	private static Logger logger = LoggerFactory.getLogger(SpiderTimerTask.class);
	
	//一天只发250封每个账号邮件 --多少个账号以后再说
	
	@Value("${email.limit}")
	private long limit;
	
	@Resource
	private MainEmailMapper mainEmailMapper;
	
	@Resource
	private ImageAccessMapper imageAccessMapper;
	
	@Resource
	private RedisDao redisDaoImpl;
	
	
	private ExecutorService pools = Executors.newCachedThreadPool();
	
	public Long sendEmail(long start,String username,String passwrod){//开始坐标从redis中取,默认为0---对应id
		
		Long startPic = redisDaoImpl.getValueByKeyNum(RedisKeyUtil.getSendPicStartValue());
		
		String url = imageAccessMapper.findImageByEmail(startPic);
		
		redisDaoImpl.incrValueByKey(RedisKeyUtil.getSendPicStartValue());
		
		//这里先查一下一共邮箱的数量 --计算这次发送规则,存入redis下次的起始位置
		
		Long max = mainEmailMapper.findEmailMaxNum();
		
		redisDaoImpl.setValueByKey(RedisKeyUtil.getSendEmailStartValue(), (start+limit)+"");
		
		if(max<start+limit){
			limit = max -start;
			redisDaoImpl.setValueByKey(RedisKeyUtil.getSendEmailStartValue(),"0");
		}
		
		//这里都是一个线程发了 邮箱有发送限制,一个线程就够了 唉
			
		SendEmail sendEmail = new SendEmail(start,start+limit,url,username,passwrod);
			
		pools.submit(sendEmail);
			
		//乘以线程数
		return limit;
	}
	
	/**
	 * 多线程发送邮件
	 * <p>Title: SendEmailServiceImpl.java</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016</p>
	 * <p>Company: Sage</p>
	 * @author 五虎将
	 * @date 2016年9月11日下午10:03:03
	 * @version 1.0
	 */
	class SendEmail implements Runnable{

		private long start;
		
		private long limit;
		
		private String picUrl;
		
		private String username;
		
		private String password;

		public SendEmail(long start,long limit,String picUrl,String username,String passwrod) {
			 this.start = start;
			 this.limit = limit;
			 this.picUrl = picUrl;
			 this.username=username;
			 this.password=passwrod;
		}
		
		
		@Override
		public void run() {
			long timestart = System.currentTimeMillis();
			PicEmail picEmail = new PicEmail();
			
			picEmail.setPicUrl(picUrl);
			
			while(start<limit){
				List<String> emails = mainEmailMapper.findEmailByRandge(start);
				for (String email : emails) {
					try {
							SendmailUtil sendmailUtil = new SendmailUtil(username,password);
							sendmailUtil.doSendHtmlEmail(picEmail.getHeadName(), picEmail,email);
		
					} catch (UnsupportedEncodingException |MessagingException    e) {
						logger.error("send email occor error ,the email is "+email+"the error is : "+ e);
					}
				}
				start = start+10;
			}
			
		 long endtime = System.currentTimeMillis();	
		 logger.warn("send email is end ,the end limit is :"+limit +" and send cost time is :" + (endtime-timestart)+"ms");
		}
		
	}
}
