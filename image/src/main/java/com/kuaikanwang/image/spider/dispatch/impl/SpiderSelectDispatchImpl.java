package com.kuaikanwang.image.spider.dispatch.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuaikanwang.image.spider.cto.main.CTOMainProcessor;
import com.kuaikanwang.image.spider.cto.pre.CTOPageProcessorTest;
import com.kuaikanwang.image.spider.dispatch.SpiderSelectDispatch;
import com.kuaikanwang.image.spider.mm131.main.MMMainPageProcessor;
import com.kuaikanwang.image.spider.mm131.pre.MMPrePageProcessor;
import com.kuaikanwang.image.spider.souutu.main.SouutuMainPageProcessor;
import com.kuaikanwang.image.spider.souutu.pre.SouutuPrePageProcessor;

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
	
	
	@Override
	public boolean callPreSpider(long webId, String url) {
		if(webId ==1){
			Spider.create(new CTOPageProcessorTest()).addPipeline(preMysqlPipeline).
			addUrl(url).
			thread(7).run();
		}
		else if(webId ==2){
			Spider.create(new MMPrePageProcessor()).addPipeline(preMysqlPipeline).
			addUrl(url).
			thread(7).run();
		}
		else if (webId ==3) {
			Spider.create(new SouutuPrePageProcessor()).addPipeline(preMysqlPipeline).
			addUrl(url).
			thread(7).run();
		}
		return true;
	}

	@Override
	public boolean callMainSpider(long webId, String url) {
		
		if(webId ==1){
			
			Spider.create(new CTOMainProcessor()).addPipeline(mainMysqlPipeline)
			.addUrl(url).thread(7).run();
			
		}
		else if (webId ==2) {
			Spider.create(new MMMainPageProcessor()).addPipeline(mainMysqlPipeline)
			.addUrl(url).thread(7).run();
		}
		else if (webId ==3) {
			Spider.create(new SouutuMainPageProcessor()).addPipeline(mainMysqlPipeline)
			.addUrl(url).thread(7).run();
		}
		return true;
	}


}
