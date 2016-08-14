package com.kuaikanwang.image.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kuaikanwang.image.domain.bean.ImageType;
import com.kuaikanwang.image.domain.result.ImageList;
import com.kuaikanwang.image.domain.result.ResultData;
import com.kuaikanwang.image.service.AppSimpleShowService;
import com.kuaikanwang.image.service.IImageAccessService;
import com.kuaikanwang.image.service.MWebAccessService;
import com.kuaikanwang.image.utils.PageNumberListUtils;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;
/**
 * m 站访问数据接口
 * <p>Title: MWebAccessController.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年8月14日下午1:50:43
 * @version 1.0
 */
@Controller
@RequestMapping("/m/image")
public class MWebAccessController {
	
	@Resource
	private MWebAccessService mWebAccessServiceImpl;
	
	
	/**
	 * 展示目录列表
	 * <p>Title: ShowPicList</p>
	 * <p>Description: </p>
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/show/list")
	@ResponseBody
	public ResultData<List<ImageType>> ShowPicList(){
		
		ResultData<List<ImageType>> result ;
		
		try {
			result = new ResultData<List<ImageType>>();
			
			result.setData(CommonCacheUtil.getImageTypeList());
			result.setSuccess(true);
			result.setTotalCount((long) CommonCacheUtil.getImageTypeList().size());
			
			return result;
			
		} catch (Exception e) {
			result = new ResultData<List<ImageType>>();
			result.setSuccess(false);
			result.setMessage("occor unkonw error !");
		}
		return result;
	}
	/**
	 * 图片展示
	 * <p>Title: ShowPicList</p>
	 * <p>Description: </p>
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/{imageType}/detail/list")
	@ResponseBody
	public ModelAndView ShowDetailPicList(@PathVariable int imageType ,
			@RequestParam(defaultValue="1") int pageNum){
		
			/**
			 * 从缓存中校验一下 是不是有图片类型,没有默认使用1
			  */
			boolean flag = CommonCacheUtil.getImageTypeNameCache().containsKey(new Long(imageType));
			if(!flag){
				imageType = 1;
			}
			
			Integer totalPage = mWebAccessServiceImpl.findTotalPageNumByImageType(imageType, 15);
			
			if(pageNum <1 || pageNum > totalPage){
				pageNum = 1;
			}
			
			//查询分类下主表的图片
			List<ImageList> imageList = mWebAccessServiceImpl.findMWebImageList(pageNum,imageType);
			
			
			Map<String, Object> model  = new HashMap<String,Object>();
			
			model.put("list", imageList);
			
			model.put("maxPage", totalPage);
			model.put("nowPage", pageNum);
			model.put("nowImageType", CommonCacheUtil.getImageTypeList().get(imageType-1));
			//要暂时的列表页
			List<Integer> pageList = PageNumberListUtils.getPageNumList(pageNum, totalPage);
			
			model.put("pageList", pageList);
			
		     
		     return new ModelAndView("/mweb",model);
	}
	
	
}
