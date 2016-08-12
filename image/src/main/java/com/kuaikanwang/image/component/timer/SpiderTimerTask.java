package com.kuaikanwang.image.component.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuaikanwang.image.spider.start.SpiderStart;

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
@Component
public class SpiderTimerTask {

	@Autowired
	private SpiderStart spiderStartImpl;
	
	public void work(){
		Long count = spiderStartImpl.preSpiderStart(1l);
	}
	
}