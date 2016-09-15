package com.kuaikanwang.image.component.timer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kuaikanwang.image.service.ImageExtendService;
/**
 * 最新图片列表 定时更新类
 * <p>Title: LatestPicListTask.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年8月6日下午6:23:31
 * @version 1.0
 */

public class CountPicListTask {

	@Resource
	private ImageExtendService imageExtendServiceImpl;
	

	public void work(){
		imageExtendServiceImpl.getCountPicList(10);
	}
	
	
}
