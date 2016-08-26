package com.kuaikanwang.image.component.timer;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kuaikanwang.image.service.IImageAccessService;
import com.kuaikanwang.image.service.ImageExtendService;
import com.kuaikanwang.image.service.impl.ImageAccessServiceImpl;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;
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
@Component
public class MaxPidTask {

	@Resource
	private ImageExtendService imageExtendServiceImpl;
	
	@Resource
	private IImageAccessService imageAccessServiceImpl;
	
	public void work(){
		imageExtendServiceImpl.getMaxPic();
		
		
		//清理图片分类总书目缓存信息
		CommonCacheUtil.getTypeCountCache().clear();
		
	}
	
	
	
}
