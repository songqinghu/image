package com.kuaikanwang.image.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kuaikanwang.image.service.LookCountService;
/**
 * 统计图片观看次数
 * <p>Title: LookCountController.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年8月6日下午7:32:48
 * @version 1.0
 */
@Controller
@RequestMapping("/image/count")
public class LookCountController {

	
	@Resource
	private LookCountService lookCountServiceImpl;
	
	
	/**
	 * 统计pid对应观看次数
	 * <p>Title: addCountByPid</p>
	 * <p>Description: </p>
	 * @param pid
	 */
	@RequestMapping("/add/pid")
	public void addCountByPid(@RequestParam Long pid){
		
		lookCountServiceImpl.addCountByPid(pid);
	}
	
	
}
