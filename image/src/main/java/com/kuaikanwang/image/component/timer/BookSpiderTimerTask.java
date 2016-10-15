package com.kuaikanwang.image.component.timer;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.kuaikanwang.image.dao.SpiderInfoMapper;
import com.kuaikanwang.image.redis.RedisDao;
import com.kuaikanwang.image.spider.book.start.BookSpiderStart;
import com.kuaikanwang.image.utils.redis.RedisKeyUtil;

public class BookSpiderTimerTask implements InitializingBean{

	private static Logger logger = LoggerFactory.getLogger(EmailSpiderTimerTask.class);
	
	@Autowired
	private  BookSpiderStart bookSpiderStartImpl;
	
	@Autowired
	private SpiderInfoMapper spiderInfoMapper;
	@Resource
	private RedisDao redisDaoImpl;
	
	public void work(){
		if(redisDaoImpl.getValueByKeyAndUpdate(RedisKeyUtil.getTimeTaskKey("spider", "book"))){
			List<Long> webIds = spiderInfoMapper.findBookAllWebIds();
			
			for (final Long webId : webIds) {
				
				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {
					    long webid = webId;
						logger.warn("start email spider website the webId is " + webid);
						System.out.println(new Date() + "  start email spider website the webId is " + webid);
						long start = System.currentTimeMillis();
						Long count = bookSpiderStartImpl.bookSpiderStart(webid);
						System.out.println(new Date() + " email  spider webstie {"+webid+"} is end");
					    logger.warn("email spider webstie {"+webid+"} is end , "
					    		+ "lost time is "+(System.currentTimeMillis()-start)+"  ms"+",spider number is :" + count);
					}
				});
				thread.start();
				try {
	                thread.sleep(1500);
	            } catch (InterruptedException e) {
	                logger.error("email task spider is error : "+e);
	            }
			}
			//结束后 --将控制符设置回去
			redisDaoImpl.setValueByKey(RedisKeyUtil.getTimeTaskKey("spider", "book"), "1");
			
		}else{
			//未获取到控制符 跳过
			System.out.println("the spider mail task skip!");
		}
		
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		redisDaoImpl.setValueByKey(RedisKeyUtil.getTimeTaskKey("spider", "book"), "1");
	}
	
}
