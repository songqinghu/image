package com.kuaikanwang.image.controller.app;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kuaikanwang.image.domain.bean.gif.GifList;
import com.kuaikanwang.image.domain.result.AppImageInfo;
import com.kuaikanwang.image.domain.result.ResultData;
import com.kuaikanwang.image.service.AppSimpleShowService;
import com.kuaikanwang.image.service.GifAccessService;

/**
 * app 动态图展示接口
 * <p>Title: APPGifShowController.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年9月4日下午9:08:58
 * @version 1.0
 */


@Controller
@RequestMapping("/app/gif")
public class APPGifShowController {

	
	@Autowired
	private GifAccessService gifAccessServiceImpl;
	
	
	@RequestMapping("/show/list")
	@ResponseBody
	public ResultData<List<GifList>> ShowPicList(@RequestParam(defaultValue="1") int pageNum ,@RequestParam(defaultValue="5") int pageSize){
		
		ResultData<List<GifList>> result ;
		
		try {
			//数据校验 --最多10个
			if(pageSize >10 || pageSize <1){
				pageSize = 5;
			}
			
			//判断一共可以展示的页数 
			Integer totalPage = gifAccessServiceImpl.findGifPageTotalByPageSize(pageSize);//先展示5个试试看
			//对页数参数做处理
			if(pageNum <1){
				pageNum=1;
			}else if(pageNum > totalPage ){
				pageNum = totalPage;
			}

			//校验结束,开始查询
			
			List<GifList> gifList = gifAccessServiceImpl.findGifListByPageNum(pageNum, pageSize);
			
			result = new ResultData<List<GifList>>();
			
			result.setData(gifList);
			result.setSuccess(true);
			result.setTotalCount(new Long(totalPage));
			
			return result;
			
		} catch (Exception e) {
			result = new ResultData<List<GifList>>();
			result.setSuccess(false);
			result.setMessage("occor unkonw error !");
		}
		return result;
	}
	
	
}
