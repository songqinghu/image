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
import com.kuaikanwang.image.domain.result.DetailImage;
import com.kuaikanwang.image.domain.result.ImageList;
import com.kuaikanwang.image.domain.result.ResultData;
import com.kuaikanwang.image.service.AppSimpleShowService;
import com.kuaikanwang.image.service.IImageAccessService;
import com.kuaikanwang.image.service.MWebAccessService;
import com.kuaikanwang.image.utils.PageNumberListUtils;
import com.kuaikanwang.image.utils.arithmetic.SimpleImageListArithmeticUtil;
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
	
	@Autowired
	private IImageAccessService imageAccessServiceImpl;
	
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
	 * 图片展示 ---改为显示分类下的单张图片
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
			Integer totalPage =	imageAccessServiceImpl.findTotalPageNum(imageType,15);//M站展示15
			
			if(pageNum<=0 ){
				pageNum=1;
			}else if ( pageNum >totalPage) {
				pageNum = totalPage;
			}
			
			//查询分类下主表的图片
			List<ImageList> imageList = imageAccessServiceImpl.findImageList(pageNum,imageType);
			
			
			Map<String, Object> model  = new HashMap<String,Object>();
			
			model.put("list", imageList);
			
			model.put("maxPage", totalPage);
			model.put("nowPage", pageNum);
			model.put("nowImageType", CommonCacheUtil.getImageTypeList().get(imageType-1));
			//要暂时的列表页
			List<Integer> pageList = PageNumberListUtils.getPageNumList(pageNum, totalPage);
			
			model.put("pageList", pageList);
			
		     
		    return new ModelAndView("/mimage",model);
	}
	
	/**
	 * 获取M站图片详情
	 * <p>Title: getDetail</p>
	 * <p>Description: </p>
	 * @return
	 */
	@RequestMapping("/detail")
	public ModelAndView getDetail(@RequestParam(defaultValue="1") int pid ,@RequestParam(defaultValue="1") int pageNum){
		
		
		Integer totalCount = imageAccessServiceImpl.findTotalCount(pid);//大于等于0
		
		//确定要获取的详情图片
		if(totalCount==0){//指定的pid下没有图片--推荐浏览量最高的--先做成默认的
			pid = 1;
			pageNum =1;
		}else if(pageNum <1){
			pageNum =1;
		}else if(pageNum > totalCount){
			pageNum = totalCount;
		}
		
		Map<String, Object> model  = new HashMap<String,Object>();
		
		//获取详情图片,按照浏览量排序--增加详情图片浏览量,增加列表页浏览量
		
		DetailImage image = imageAccessServiceImpl.getDetailImage(pid, pageNum);
		
		//设置分类及分类链接--待加
		
		
		 model.put("image", image);
	     model.put("maxPage", totalCount);
	     model.put("nowPage", pageNum);
		 model.put("pid", pid);	
		 model.put("imageTypeList", CommonCacheUtil.getImageTypeList());
		 model.put("nowImageType", CommonCacheUtil.getImageTypeList().get(image.getPictype()-1));
	     //要暂时的列表页
	     List<Integer> pageList = PageNumberListUtils.getPageNumList(pageNum, totalCount);
			
	     model.put("pageList", pageList);
			
	     //扩展展示内容
	     
	     //上一组和下一组的图片
	     ImageList previousImage = imageAccessServiceImpl.getPreviousImageByPid(pid,image.getPictype());
	     ImageList nextImage = imageAccessServiceImpl.getNextImageByPid(pid, image.getPictype());
	     model.put("previousImage", previousImage);	
	     model.put("nextImage", nextImage);	
	     
	     
		 return new ModelAndView("/mdetail",model);
	}
}
