package com.kuaikanwang.image.spider.dispatch.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuaikanwang.image.spider.container.PageProcessorContainer;
import com.kuaikanwang.image.spider.dispatch.SpiderSelectDispatch;
import com.kuaikanwang.image.spider.email.pipline.EmailMainMysqlPipeline;
import com.kuaikanwang.image.spider.email.pipline.EmailPreMysqlPipeline;

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
	
	//预处理存入数据库 动态图
	@Resource
	private Pipeline gifPreMysqlPipeline;
	@Autowired
	private Pipeline gifMainMysqlPipeline;
	
	//邮箱部分 入mysql
	@Resource
	private Pipeline emailPreMysqlPipeline;
	
	@Resource
	private Pipeline emailMainMysqlPipeline;
	
	//爬虫容器
	@Resource
	private PageProcessorContainer pageProcessorContainer;
	
	
	
	
	@Override
	public boolean callPreSpider(long webId, String url) {
		
		if(pageProcessorContainer.getPrePageProcessorContainer().containsKey(webId)){
			Spider
			.create(pageProcessorContainer.getPrePageProcessorContainer()
			.get(webId))
			.addPipeline(preMysqlPipeline).
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

	@Override
	public boolean callPreGifSpider(long gwebId, String url) {
		
		if(pageProcessorContainer.getPrePageProcessorContainer().containsKey(gwebId)){
			Spider.
			create(pageProcessorContainer.getPreGifPageProcessorContainer().get(gwebId))
			.addPipeline(gifPreMysqlPipeline).
			addUrl(url).
			thread(7).run();
		}
		
		return true;
	}

	@Override
	public boolean callMaicGifSpider(long gwebId, String url) {
		if(pageProcessorContainer.getMainPageProcessorContainer().containsKey(gwebId)){
			Spider.create(pageProcessorContainer.getMainGifPageProcessorContainer().get(gwebId)).
			addPipeline(gifMainMysqlPipeline)
			.addUrl(url).thread(7).run();
		}
		

		return true;
	}

	//邮箱部分
	
	
	@Override
	public boolean callPreEmailSpider(long emailwebId, String url) {
		
		if(pageProcessorContainer.getPreEmailPageProcessorContainer().containsKey(emailwebId)){
			Spider.
			create(pageProcessorContainer.getPreEmailPageProcessorContainer().get(emailwebId))
			.addPipeline(emailPreMysqlPipeline).
			addUrl(url).
			thread(7).run();
		}
		
		return true;
	}

	@Override
	public boolean callMainEmailSpider(long emailwebId, String url) {
		
		if(pageProcessorContainer.getMainEmailPageProcessorContainer().containsKey(emailwebId)){
			Spider.
			create(pageProcessorContainer.getMainEmailPageProcessorContainer().get(emailwebId))
			.addPipeline(emailMainMysqlPipeline).
			addUrl(url).
			thread(7).run();
		}
		
		return true;
	}


}
