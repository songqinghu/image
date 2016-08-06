package com.kuaikanwang.image.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaikanwang.image.domain.result.AppImageInfo;
import com.kuaikanwang.image.domain.result.ResultData;
import com.kuaikanwang.image.service.AppSimpleShowService;

/**
 * 为app提供简单的数据列表展示
 * <p>Title: AppSimpleShowController.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年8月6日下午1:39:59
 * @version 1.0
 */
@Controller
@RequestMapping("/image/app")
public class AppSimpleShowController {

	
	@Resource
	private AppSimpleShowService appSimpleShowServiceImpl;
	
	
	@RequestMapping("/show/list")
	@ResponseBody
	public ResultData<List<AppImageInfo>> ShowPicList(@RequestParam(defaultValue="1") int pageNum ,@RequestParam(defaultValue="10") int pageSize){
		
		ResultData<List<AppImageInfo>> result ;
		
		try {
			//数据校验
			if(pageSize >20 || pageSize <1){
				pageSize = 10;
			}
			
			Integer totalPage = appSimpleShowServiceImpl.findTotalPageNum(pageSize);
			
			if(pageNum <1 || pageNum > totalPage){
				pageNum = 1;
			}
			//校验结束,开始查询
			
			List<AppImageInfo> data = appSimpleShowServiceImpl.findImageByPage(pageNum, pageSize);
			
			result = new ResultData<List<AppImageInfo>>();
			
			result.setData(data);
			result.setSuccess(true);
			result.setTotalCount(new Long(totalPage));
			
			return result;
			
		} catch (Exception e) {
			result = new ResultData<List<AppImageInfo>>();
			result.setSuccess(false);
			result.setMessage("occor unkonw error !");
		}
		return result;
	}
	
	
	
}
