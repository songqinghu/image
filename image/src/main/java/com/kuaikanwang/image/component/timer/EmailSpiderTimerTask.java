package com.kuaikanwang.image.component.timer;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuaikanwang.image.dao.SpiderInfoMapper;
import com.kuaikanwang.image.spider.email.start.EmailSpiderStart;

/**
 * 邮箱定时抓取
 * <p>Title: EmailSpiderTimerTask.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年9月13日下午9:55:01
 * @version 1.0
 */
@Component
public class EmailSpiderTimerTask {

	private static Logger logger = LoggerFactory.getLogger(EmailSpiderTimerTask.class);
	
	@Autowired
	private EmailSpiderStart emailSpiderStartImpl;
	
	@Autowired
	private SpiderInfoMapper spiderInfoMapper;
	
	public void work(){
		
		List<Long> webIds = spiderInfoMapper.findEmailAllWebIds();
		
		for (final Long webId : webIds) {
			
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
				    long webid = webId;
					logger.warn("start email spider website the webId is " + webid);
					System.out.println(new Date() + "  start email spider website the webId is " + webid);
					long start = System.currentTimeMillis();
					Long count = emailSpiderStartImpl.spiderStart(webid);
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
		
	}
	
	
}
