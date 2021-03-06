package com.kuaikanwang.image.component.timer;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuaikanwang.image.dao.SpiderInfoMapper;
import com.kuaikanwang.image.redis.RedisDao;
import com.kuaikanwang.image.spider.start.SpiderStart;
import com.kuaikanwang.image.utils.redis.RedisKeyUtil;

/**
 * 爬虫定时爬取控制类
 * <p>Title: SpiderTimerTask.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年8月7日下午7:10:51
 * @version 1.0
 */

public class SpiderTimerTask implements InitializingBean{

	private static Logger logger = LoggerFactory.getLogger(SpiderTimerTask.class);
	
	@Autowired
	private SpiderStart spiderStartImpl;
	
	@Autowired
	private SpiderInfoMapper spiderInfoMapper;
	
	@Resource
	private RedisDao redisDaoImpl;
	
	
	public void work(){
		if(redisDaoImpl.getValueByKeyAndUpdate(RedisKeyUtil.getTimeTaskKey("spider", "pic"))){
			List<Long> webIds = spiderInfoMapper.findAllWebIds();
			
			for (final Long webId : webIds) {
				
				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {
					    long webid = webId;
						logger.warn("start spider website the webId is " + webid);
						System.out.println(new Date() + "  start spider website the webId is " + webid);
						long start = System.currentTimeMillis();
						Long count = spiderStartImpl.preSpiderStart(webid);
						System.out.println(new Date() + "  spider webstie {"+webid+"} is end");
					    logger.warn("spider webstie {"+webid+"} is end , "
					    		+ "lost time is "+(System.currentTimeMillis()-start)+"  ms"+",spider number is :" + count);
					}
				});
				thread.start();
				try {
	                thread.sleep(1500);
	            } catch (InterruptedException e) {
	                logger.error(" task spider is error : "+e);
	            }
			}
			//结束后 --将控制符设置回去
			redisDaoImpl.setValueByKey(RedisKeyUtil.getTimeTaskKey("spider", "pic"), "1");
		}else{
			//未获取到控制符 跳过
			System.out.println("the spider pic task skip!");
		}
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		redisDaoImpl.setValueByKey(RedisKeyUtil.getTimeTaskKey("spider", "pic"), "1");
	}
}
