package com.kuaikanwang.image.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaikanwang.image.spider.cto.start.CTOPreSpiderStart;

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
@RequestMapping("/image/spider")
public class SpiderTestController {

	@Autowired
	private CTOPreSpiderStart ctoPreSpiderStartImpl;
	
	/**
	 * 图片预抓取
	 * <p>Title: spiderStartTest</p>
	 * <p>Description: </p>
	 * @return
	 */
	@RequestMapping("/start")
	@ResponseBody
	public String spiderStartTest(){
		ctoPreSpiderStartImpl.preSpiderStart(1l);
		return "抓取结束!";
	}
	
	
}
