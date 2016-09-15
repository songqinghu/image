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
import com.kuaikanwang.image.spider.gif.start.GifSpiderStart;
import com.kuaikanwang.image.spider.start.SpiderStart;
import com.kuaikanwang.image.utils.redis.RedisKeyUtil;

/**
 * 动态图定时任务
 * <p>Title: GifSpiderTimerTask.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年9月4日下午3:12:43
 * @version 1.0
 */

public class GifSpiderTimerTask implements InitializingBean{

	private static Logger logger = LoggerFactory.getLogger(GifSpiderTimerTask.class);
	
	@Autowired
	private GifSpiderStart gifSpiderStartImpl;
	
	@Autowired
	private SpiderInfoMapper spiderInfoMapper;
	
	@Resource
	private RedisDao redisDaoImpl;
	
	public void work(){
		if(redisDaoImpl.getValueByKeyAndUpdate(RedisKeyUtil.getTimeTaskKey("spider", "gif"))){
			List<Long> webIds = spiderInfoMapper.findGifAllWebIds();
			
			for (final Long webId : webIds) {
				
				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {
					    long webid = webId;
						logger.warn("start gif spider website the webId is " + webid);
						System.out.println(new Date() + "  start gif spider website the webId is " + webid);
						long start = System.currentTimeMillis();
						Long count = gifSpiderStartImpl.preSpiderStart(webid);
						System.out.println(new Date() + " gif  spider webstie {"+webid+"} is end");
					    logger.warn("gif spider webstie {"+webid+"} is end , "
					    		+ "lost time is "+(System.currentTimeMillis()-start)+"  ms"+",spider number is :" + count);
					}
				});
				thread.start();
				try {
	                thread.sleep(1500);
	            } catch (InterruptedException e) {
	                logger.error("gif task spider is error : "+e);
	            }
			}
			//结束后 --将控制符设置回去
			redisDaoImpl.setValueByKey(RedisKeyUtil.getTimeTaskKey("spider", "gif"), "1");
		}else{
			//未获取到控制符 跳过
			System.out.println("the spider gif task skip!");
		}
		
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		redisDaoImpl.setValueByKey(RedisKeyUtil.getTimeTaskKey("spider", "gif"), "1");
	}
}
