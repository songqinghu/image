package com.kuaikanwang.image.controller.pc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kuaikanwang.image.domain.bean.gif.GifList;
import com.kuaikanwang.image.domain.result.ImageList;
import com.kuaikanwang.image.service.GifAccessService;
import com.kuaikanwang.image.service.ImageExtendService;
import com.kuaikanwang.image.service.impl.GifAccessServiceImpl;
import com.kuaikanwang.image.utils.PageNumberListUtils;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

/**
 * 动态图访问控制接口
 * <p>Title: GifAccessController.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年9月3日上午9:57:34
 * @version 1.0
 */
@Controller
@RequestMapping("/gif")
public class GifAccessController {

	@Autowired
	private GifAccessService gifAccessServiceImpl;
	
	@Autowired
	private ImageExtendService imageExtendServiceImpl;
	
	/**
	 * 列表页展示动态图
	 * <p>Title: gifListShow</p>
	 * <p>Description: </p>
	 */
	@RequestMapping("/list")
	public ModelAndView  gifListShow(@RequestParam(defaultValue="1") Integer pageNum){
		
		//判断一共可以展示的页数 
		Integer pageSize = 10;
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
		List<Integer> pageList = PageNumberListUtils.getPageNumList(pageNum, totalPage);
		
		model.put("pageList", pageList);
		
		//扩展信息 
		//随机算法推荐的图片 --展示名字 --展示最新
		//浏览量最高的图片 16个
		List<ImageList> newPicList = imageExtendServiceImpl.getLatestPicList(20);
		List<ImageList> maxCountPicList = imageExtendServiceImpl.getCountPicList(20);
		
		model.put("newList", newPicList);
		model.put("maxList", maxCountPicList);
		
		return new ModelAndView("/gif",model);
		
		
	}
	
	
}
