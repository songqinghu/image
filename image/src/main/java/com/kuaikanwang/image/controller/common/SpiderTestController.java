package com.kuaikanwang.image.controller.common;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaikanwang.image.spider.gif.start.GifSpiderStart;
import com.kuaikanwang.image.spider.gif.start.impl.GifSpiderStartImpl;
import com.kuaikanwang.image.spider.start.SpiderStart;

/**
 * 爬虫功能测试类
 * <p>Title: SpiderTestController.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年7月27日下午11:29:32
 * @version 1.0
 */
@Controller
@RequestMapping("/spider")
public class SpiderTestController {

	@Autowired
	private SpiderStart ctoPreSpiderStartImpl;
	
	@Resource
	private GifSpiderStart gifSpiderStartImpl;
	
	/**
	 * 图片抓取
	 * <p>Title: spiderStartTest</p>
	 * <p>Description: </p>
	 * @return
	 */
	@RequestMapping("/start/img")
	@ResponseBody
	public Object spiderStartTest(@RequestParam(defaultValue="1") Long webId){
		Long count = ctoPreSpiderStartImpl.preSpiderStart(webId);
		return count;
	}
	
	
	
	/**
	 * 动态图抓取
	 * <p>Title: spiderStartTest</p>
	 * <p>Description: </p>
	 * @return
	 */
	@RequestMapping("/start/gif")
	@ResponseBody
	public Object spiderStartGif(@RequestParam(defaultValue="1") Long webId){
		
		Long count = gifSpiderStartImpl.preSpiderStart(webId);
		
		return count;
	}
	
	
	@RequestMapping("/show/count")
	@ResponseBody
	public Object spiderAccessCount(){
		return true;
	}
	
	
	
}
