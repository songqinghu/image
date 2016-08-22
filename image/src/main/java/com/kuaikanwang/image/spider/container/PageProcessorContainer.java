package com.kuaikanwang.image.spider.container;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import us.codecraft.webmagic.processor.PageProcessor;
/**
 * 爬虫页面处理过程容器类---加载所有的项目容器
 * <p>Title: PageProcessorContainer.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年8月11日下午11:00:29
 * @version 1.0
 */
@Component
public class PageProcessorContainer implements InitializingBean{

	
	private Map<Long, PageProcessor> prePageProcessorContainer = new HashMap<Long, PageProcessor>();
	
	private Map<Long, PageProcessor> mainPageProcessorContainer = new HashMap<Long, PageProcessor>();
	
	//预处理部分
	
	@Resource
	private PageProcessor ctoPrePageProcessor;
	@Resource
	private PageProcessor mmPrePageProcessor;
	@Resource
	private PageProcessor souutuPrePageProcessor;
	@Resource
	private PageProcessor mzituPrePageProcessor;
	@Resource
	private PageProcessor kuPrePageProcessor;
	
	
	//主抓取部分
	@Resource
	private PageProcessor ctoMainPageProcessor;
	@Resource
	private PageProcessor mmMainPageProcessor;
	@Resource
	private PageProcessor souutuMainPageProcessor;
	@Resource
	private PageProcessor mzituMainPageProcessor;
	@Resource
	private PageProcessor kuMainPageProcessor;
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
		//预处理
		prePageProcessorContainer.put(1l, ctoPrePageProcessor);
		prePageProcessorContainer.put(2l, mmPrePageProcessor);
		prePageProcessorContainer.put(3l, souutuPrePageProcessor);
		prePageProcessorContainer.put(4l, mzituPrePageProcessor);
		prePageProcessorContainer.put(5l, kuPrePageProcessor);
		
		
		
		//主抓取
		mainPageProcessorContainer.put(1l, ctoMainPageProcessor);
		mainPageProcessorContainer.put(2l, mmMainPageProcessor);
		mainPageProcessorContainer.put(3l, souutuMainPageProcessor);
		mainPageProcessorContainer.put(4l, mzituMainPageProcessor);
		mainPageProcessorContainer.put(5l, kuMainPageProcessor);
		
	}


	public Map<Long, PageProcessor> getPrePageProcessorContainer() {
		return prePageProcessorContainer;
	}


	public Map<Long, PageProcessor> getMainPageProcessorContainer() {
		return mainPageProcessorContainer;
	}


	
	
	

}
