package com.kuaikanwang.image.controller.mobile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuaikanwang.image.domain.bean.gif.GifList;
import com.kuaikanwang.image.domain.result.ImageList;
import com.kuaikanwang.image.service.GifAccessService;
import com.kuaikanwang.image.utils.PageNumberListUtils;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

/**
 * m站访问动态图接口
 * <p>Title: MGifAccessController.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年9月4日下午8:34:27
 * @version 1.0
 */
@Component
@RequestMapping("/m/gif")
public class MGifAccessController {

	@Autowired
	private GifAccessService gifAccessServiceImpl;
	
	/**
	 * m站展示 gif
	 * <p>Title: ShowDetailGifList</p>
	 * <p>Description: </p>
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/detail/list")
	@ResponseBody
	public ModelAndView ShowDetailGifList(@RequestParam(defaultValue="1") int pageNum){
		
		//判断一共可以展示的页数 
				Integer pageSize = 5;
				Integer totalPage = gifAccessServiceImpl.findGifPageTotalByPageSize(pageSize);//先展示5个试试看
				//对页数参数做处理
				if(pageNum <1){
					pageNum=1;
				}else if(pageNum > totalPage ){
					pageNum = totalPage;
				}
				
				//进行查询获取动态图列表
				
				List<GifList> gifList = gifAccessServiceImpl.findGifListByPageNum(pageNum, pageSize);
				
				Map<String, Object> model  = new HashMap<String,Object>();
				
				model.put("list", gifList);
				model.put("maxPage", totalPage);
				model.put("nowPage", pageNum);
				//要暂时的列表页
				List<Integer> pageList = PageNumberListUtils.getPageNumList4M(pageNum, totalPage);
				
				model.put("pageList", pageList);
			
		     
		    return new ModelAndView("/mgif",model);
	}
	
	
	
}
