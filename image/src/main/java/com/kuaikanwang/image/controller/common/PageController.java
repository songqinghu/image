package com.kuaikanwang.image.controller.common;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaikanwang.image.redis.RedisDao;

/**
 * 页面跳转类
 * <p>Title: PageController.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年7月11日下午10:13:59
 * @version 1.0
 */

@Controller
@RequestMapping("/page")
public class PageController {

	@RequestMapping("/to/{pageName}")
	public String toPage(@PathVariable String pageName){
		
		return pageName;
	}
	
	@Resource
	private RedisDao redisDaoImpl;
	
	@RequestMapping("/cache/{key}")
	@ResponseBody
	public String cacheKey(@PathVariable String key){
		
		redisDaoImpl.setValueByKey("127.0.0.1");
		
		return "success";
	}
	
	
	
}
