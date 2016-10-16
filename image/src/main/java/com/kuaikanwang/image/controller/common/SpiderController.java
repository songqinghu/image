package com.kuaikanwang.image.controller.common;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaikanwang.image.spider.book.start.BookSpiderStart;
import com.kuaikanwang.image.spider.email.start.EmailSpiderStart;
import com.kuaikanwang.image.spider.gif.start.GifSpiderStart;
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
public class SpiderController {

	@Autowired
	private SpiderStart ctoPreSpiderStartImpl;
	
	@Resource
	private GifSpiderStart gifSpiderStartImpl;
	
	
	@Resource
	private EmailSpiderStart emailSpiderStartImpl;
	
	@Resource
	private BookSpiderStart bookSpiderStartImpl;
	
	
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
	/**
	 * 爬取邮箱
	 * <p>Title: spiderStartEmail</p>
	 * <p>Description: </p>
	 * @return
	 */
	@RequestMapping("/start/email")
	@ResponseBody
	public Object spiderStartEmail(@RequestParam(defaultValue="1") Long emailwebId){
		
		Long count = emailSpiderStartImpl.spiderStart(emailwebId);
		
		return count;
		
	}
	/**
	 * 图书爬取
	 * <p>Title: spiderStartBook</p>
	 * <p>Description: </p>
	 * @return
	 */
	@RequestMapping("/start/book")
	@ResponseBody
	public Object spiderStartBook(@RequestParam(defaultValue="1") Long webId){
		
		Long count = bookSpiderStartImpl.bookSpiderStart(webId);
		
		return count;
		
	}
	
	/**
	 * 爬取所有的图书的简介信息 在爬取单本前执行
	 * <p>Title: spiderStartBook</p>
	 * <p>Description: </p>
	 * @return
	 */
	@RequestMapping("/start/book/intro")
	@ResponseBody
	public Object spiderAllBookIntro(@RequestParam(defaultValue="1") Long webId){
		
		//爬取所有图书简介
		bookSpiderStartImpl.spiderAllBookIntro(webId);
		
		return true;
		
	}
	
	
	
	/**
	 * 图书爬取指定的书籍
	 * <p>Title: spiderStartBook</p>
	 * <p>Description: </p>
	 * @return
	 */
	@RequestMapping("/start/one/book")
	@ResponseBody
	public Object spiderStartOneBook(@RequestParam(defaultValue="1") Long introId){
		
		
		Long count = bookSpiderStartImpl.spiderOneBookStart(introId);
		
		return count;
		
	}
	
	
	
	
	
	/**
	 * 反爬虫统计
	 * <p>Title: spiderAccessCount</p>
	 * <p>Description: </p>
	 * @return
	 */
	@RequestMapping("/show/count")
	@ResponseBody
	public Object spiderAccessCount(){
		return true;
	}
	
	
	
}
