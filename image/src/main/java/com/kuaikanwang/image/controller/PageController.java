package com.kuaikanwang.image.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping("/{pageName}")
	public String toPage(@PathVariable String pageName){
		
		return pageName;
	}
}
