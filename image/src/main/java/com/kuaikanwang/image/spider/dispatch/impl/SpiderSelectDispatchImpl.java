package com.kuaikanwang.image.spider.dispatch.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuaikanwang.image.spider.container.PageProcessorContainer;
import com.kuaikanwang.image.spider.dispatch.SpiderSelectDispatch;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * 爬虫选择调度器
 * <p>Title: SpiderSelectDispatchImpl.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年8月10日下午10:45:12
 * @version 1.0
 */
@Component
public class SpiderSelectDispatchImpl implements SpiderSelectDispatch {

	
	@Resource
	private Pipeline preMysqlPipeline;
	
	@Autowired
	private Pipeline mainMysqlPipeline;
	
	
	//爬虫容器
	@Resource
	private PageProcessorContainer pageProcessorContainer;
	
	
	
	
	@Override
	public boolean callPreSpider(long webId, String url) {
		
		if(pageProcessorContainer.getPrePageProcessorContainer().containsKey(webId)){
			Spider.create(pageProcessorContainer.getPrePageProcessorContainer().get(webId)).addPipeline(preMysqlPipeline).
			addUrl(url).
			thread(7).run();
		}

		return true;
	}

	@Override
	public boolean callMainSpider(long webId, String url) {
		
		
		if(pageProcessorContainer.getMainPageProcessorContainer().containsKey(webId)){
			Spider.create(pageProcessorContainer.getMainPageProcessorContainer().get(webId)).
			addPipeline(mainMysqlPipeline)
			.addUrl(url).thread(7).run();
		}
		

		return true;
	}


}
