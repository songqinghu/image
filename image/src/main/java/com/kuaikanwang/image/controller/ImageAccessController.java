package com.kuaikanwang.image.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kuaikanwang.image.service.IImageAccessService;
import com.kuaikanwang.image.service.impl.ImageAccessServiceImpl;

/**
 * 图片访问跳转及数据填充接口
 * <p>Title: ImageAccessController.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年7月20日下午10:38:31
 * @version 1.0
 */
@Controller
@RequestMapping("/image")
public class ImageAccessController {

	private IImageAccessService imageAccessServiceImpl;
	
	/**
	 * 跳转到性感分类下,并且展示指定页面的内容列表,数据填充
	 * 默认查询第一页内容,一页20个
	 * <p>Title: toXingGan</p>
	 * <p>Description: </p>
	 * @return
	 */
	@RequestMapping("/xinggan")
	public ModelAndView toXingGan(@RequestParam(defaultValue="1") int pageNum){
		//查询总的数据量,返回可分页的次数.
		
		//对分页进行校验,不满足条件进行默认查询
		
		//从数据库中取出性感分类下的名称,从详细表中选出一个图片,按照时间排序.
		
		
		
		return new ModelAndView("/xinggan", "test", "测试成功!");
	}
	
	
	
}
