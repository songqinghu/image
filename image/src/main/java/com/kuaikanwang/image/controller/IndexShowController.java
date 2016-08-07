package com.kuaikanwang.image.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * 首页数据控制接口
 * <p>Title: IndexShowController.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年8月7日下午10:25:02
 * @version 1.0
 */
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaikanwang.image.domain.result.ImageList;
import com.kuaikanwang.image.domain.result.ResultData;
import com.kuaikanwang.image.service.IndexShowService;
@Controller
@RequestMapping("/index")
public class IndexShowController {

	@Resource
	private IndexShowService indexShowServiceImpl;
	
	@RequestMapping("/show/pic")
	@ResponseBody
	public ResultData<List<ImageList>> getIndexPicByPictype(@RequestParam(defaultValue="1")Integer pictype){
		ResultData<List<ImageList>> result ;
		
		try {
			if(pictype<1 || pictype>8){
				pictype =1;
			}
			List<ImageList> list = indexShowServiceImpl.getIndexImageListByType(pictype);//前端展示是11个位置
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
