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

	//图片
	private Map<Long, PageProcessor> prePageProcessorContainer = new HashMap<Long, PageProcessor>();
	//图片
	private Map<Long, PageProcessor> mainPageProcessorContainer = new HashMap<Long, PageProcessor>();
	//动态图
	private Map<Long, PageProcessor> preGifPageProcessorContainer = new HashMap<Long, PageProcessor>();
	//动态图
	private Map<Long, PageProcessor> mainGifPageProcessorContainer = new HashMap<Long, PageProcessor>();
	//邮箱
	private Map<Long, PageProcessor> preEmailPageProcessorContainer = new HashMap<Long, PageProcessor>();
	//邮箱
	private Map<Long, PageProcessor> mainEmailPageProcessorContainer = new HashMap<Long, PageProcessor>();
	
	//预处理部分 --图片部分
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
	@Resource
	private PageProcessor picPrePageProcessor;
	@Resource
	private PageProcessor uumntPrePageProcessor;
	
	//主抓取部分 --图片部分
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
	@Resource
	private PageProcessor picMainPageProcessor;
	@Resource
	private PageProcessor uumntMainPageProcessor;
	
	
	//预处理部分 --动态图部分
	@Resource
	private PageProcessor kx1dPrePageProcessor;
	@Resource
	private PageProcessor qqszcPrePageProcessor;
	@Resource
	private PageProcessor youquPrePageProcessor;
	@Resource
	private PageProcessor manhaoxiaoPrePageProcessor;
	
	
	//主抓取部分 --动态图部分
	@Resource
	private PageProcessor kx1dMainPageProcessor;
	@Resource
	private PageProcessor qqszcMainPageProcessor;
	@Resource
	private PageProcessor youquMainPageProcessor;
	@Resource
	private PageProcessor manhaoxiaoMainPageProcessor;
	
	
	//预处理部分 --邮箱部分
	@Resource
	private PageProcessor tiebaPrePageProcessor;
	
	//主抓取部分 --邮箱部分
	@Resource
	private PageProcessor tiebaMainPageProcessor;
	
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
		//预处理 --图片
		prePageProcessorContainer.put(1l, ctoPrePageProcessor);
		prePageProcessorContainer.put(2l, mmPrePageProcessor);
		prePageProcessorContainer.put(3l, souutuPrePageProcessor);
		prePageProcessorContainer.put(4l, mzituPrePageProcessor);
		prePageProcessorContainer.put(5l, kuPrePageProcessor);
		prePageProcessorContainer.put(6l, picPrePageProcessor);
		prePageProcessorContainer.put(7l, uumntPrePageProcessor);
		
		
		
		//主抓取 --图片
		mainPageProcessorContainer.put(1l, ctoMainPageProcessor);
		mainPageProcessorContainer.put(2l, mmMainPageProcessor);
		mainPageProcessorContainer.put(3l, souutuMainPageProcessor);
		mainPageProcessorContainer.put(4l, mzituMainPageProcessor);
		mainPageProcessorContainer.put(5l, kuMainPageProcessor);
		mainPageProcessorContainer.put(6l, picMainPageProcessor);
		mainPageProcessorContainer.put(7l, uumntMainPageProcessor);
		
		
		//预处理 --动态图
		preGifPageProcessorContainer.put(1l, kx1dPrePageProcessor);
		preGifPageProcessorContainer.put(2l, qqszcPrePageProcessor);
		preGifPageProcessorContainer.put(3l, youquPrePageProcessor);
		preGifPageProcessorContainer.put(4l, manhaoxiaoPrePageProcessor);
		
		//主抓取 --动态图
		mainGifPageProcessorContainer.put(1l, kx1dMainPageProcessor);
		mainGifPageProcessorContainer.put(2l, qqszcMainPageProcessor);
		mainGifPageProcessorContainer.put(3l, youquMainPageProcessor);
		mainGifPageProcessorContainer.put(4l, manhaoxiaoMainPageProcessor);
		
		
		//预处理 --邮箱
		preEmailPageProcessorContainer.put(1l, tiebaPrePageProcessor);
		//主抓取 --邮箱
		mainEmailPageProcessorContainer.put(1l, tiebaMainPageProcessor);
		
	}


	public Map<Long, PageProcessor> getPrePageProcessorContainer() {
		return prePageProcessorContainer;
	}


	public Map<Long, PageProcessor> getMainPageProcessorContainer() {
		return mainPageProcessorContainer;
	}


	public Map<Long, PageProcessor> getPreGifPageProcessorContainer() {
		return preGifPageProcessorContainer;
	}


	public Map<Long, PageProcessor> getMainGifPageProcessorContainer() {
		return mainGifPageProcessorContainer;
	}


	public Map<Long, PageProcessor> getPreEmailPageProcessorContainer() {
		return preEmailPageProcessorContainer;
	}


	public Map<Long, PageProcessor> getMainEmailPageProcessorContainer() {
		return mainEmailPageProcessorContainer;
	}

	

}
