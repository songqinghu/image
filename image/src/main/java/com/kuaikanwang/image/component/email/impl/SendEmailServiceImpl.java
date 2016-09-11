package com.kuaikanwang.image.component.email.impl;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.component.email.SendEmailService;
import com.kuaikanwang.image.dao.ImageAccessMapper;
import com.kuaikanwang.image.dao.MainEmailMapper;
import com.kuaikanwang.image.domain.bean.email.PicEmail;
import com.kuaikanwang.image.redis.RedisDao;
import com.kuaikanwang.image.utils.mail.SendmailUtil;
import com.kuaikanwang.image.utils.redis.RedisKeyUtil;
@Service
@Transactional
public class SendEmailServiceImpl implements SendEmailService{

	
	//一天只发1w封邮件 --这里做成可调节 看效果调节
	
	@Value("${email.limit}")
	private long limit;
	
	@Resource
	private MainEmailMapper mainEmailMapper;
	
	@Resource
	private ImageAccessMapper imageAccessMapper;
	
	@Resource
	private RedisDao redisDaoImpl;
	
	
	private ExecutorService pools = Executors.newCachedThreadPool();
	
	public Long sendEmail(long start){//开始坐标从redis中取,默认为0---对应id
		
		Long startPic = redisDaoImpl.getValueByKeyNum(RedisKeyUtil.getSendPicStartValue());
		
		String url = imageAccessMapper.findImageByEmail(startPic);
		
		redisDaoImpl.incrValueByKey(RedisKeyUtil.getSendPicStartValue());
		
		//这里先查一下一共邮箱的数量 --计算这次发送规则,存入redis下次的起始位置
		
		Long max = mainEmailMapper.findEmailMaxNum();
		
		if(max<start+limit){
			limit = max -start;
		}
		
		redisDaoImpl.setValueByKey(RedisKeyUtil.getSendEmailStartValue(), (start+limit)+"");
		
		
		int threadNum = 5;
		
		limit = limit /threadNum; //可能会剩余几个不能发 --以后再处理
		
		for (int i = 0; i < threadNum; i++) {
			
			SendEmail sendEmail = new SendEmail(start,start+limit,url);
			
			pools.submit(sendEmail);
			
			start = start + limit;
			
		}
		
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

		public SendEmail(long start,long limit,String picUrl) {
			 this.start = start;
			 this.limit = limit;
			 this.picUrl = picUrl;
		}
		
		
		@Override
		public void run() {
			
			PicEmail picEmail = new PicEmail();
			
			picEmail.setPicUrl(picUrl);
			while(start<limit){
				List<String> emails = mainEmailMapper.findEmailByRandge(start);
			
				for (String email : emails) {
					picEmail.setEmail(email);
					SendmailUtil sendmailUtil = new SendmailUtil();
					
					sendmailUtil.doSendHtmlEmail(picEmail.getHeadName(), picEmail.toString(),"295533359@qq.com");
					
				}
				start = start+10;
			}
		}
		
	}
}
