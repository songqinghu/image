package com.kuaikanwang.image.controller.pc;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuaikanwang.image.domain.result.ImageList;
import com.kuaikanwang.image.domain.result.ResultData;
import com.kuaikanwang.image.service.ImageExtendService;

/**
 * 图片展示扩展功能展示
 * <p>Title: ImageExtendController.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年8月6日下午5:15:31
 * @version 1.0
 */

@Controller
@RequestMapping("/image/extend")
public class ImageExtendController {

	@Autowired
	private ImageExtendService imageExtendServiceImpl;
	
	
	/**
	 * 获取最新的图片列表
	 * <p>Title: getLatestPicList</p>
	 * <p>Description: </p>
	 * @return
	 */
	@RequestMapping("/newList")
	@ResponseBody
	public ResultData<List<ImageList>> getLatestPicList(){
		
		ResultData<List<ImageList>> result ;
		
		try {
			List<ImageList> list = imageExtendServiceImpl.getLatestPicList(11);//前端展示是11个位置
			result = new ResultData<List<ImageList>>();
			result.setSuccess(true);
			result.setData(list);
			
		} catch (Exception e) {
			result = new ResultData<List<ImageList>>();
			result.setSuccess(false);
			
		}
		return result;
	}
	
	
	@RequestMapping("/count/list")
	@ResponseBody
	public ResultData<List<ImageList>> getCountPicList(){
		
		ResultData<List<ImageList>> result ;
		
		try {
			List<ImageList> list = imageExtendServiceImpl.getCountPicList(10);
			result = new ResultData<List<ImageList>>();
			result.setSuccess(true);
			result.setData(list);
			
		} catch (Exception e) {
			result = new ResultData<List<ImageList>>();
			result.setSuccess(false);
			
		}
		return result;
	}
	
	
	
	
}
