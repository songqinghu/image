package com.kuaikanwang.image.controller.common;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaikanwang.image.service.GetImageToLocalService;

/**
 * 下载图片到本地
 * <p>Title: GetImageToLocalController.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年8月17日下午10:11:25
 * @version 1.0
 */
@Controller
@RequestMapping("/download/image")
public class GetImageToLocalController {

	
	@Resource
	private GetImageToLocalService getImageToLocalServiceImpl;
	
	@RequestMapping("/list")
	@ResponseBody
	public Object downloadImage(@RequestParam Long preId){
		
		return getImageToLocalServiceImpl.downloadImage(preId);
	}
	
	
	
}
