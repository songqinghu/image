package com.kuaikanwang.image.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kuaikanwang.image.domain.enums.ImageType;
import com.kuaikanwang.image.domain.result.DetailImage;
import com.kuaikanwang.image.domain.result.ImageList;
import com.kuaikanwang.image.service.IImageAccessService;
import com.kuaikanwang.image.service.impl.ImageAccessServiceImpl;
import com.kuaikanwang.image.utils.PageNumberListUtils;

/**
 * 图片访问跳转及数据填充接口
 * <p>Title: ImageAccessController.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年7月20日下午10:38:31
 * @version 1.0
 */
@Controller
@RequestMapping("/images")
public class ImageAccessController {

	@Autowired
	private IImageAccessService imageAccessServiceImpl;
	
	/**
	 * 跳转到性感分类下,并且展示指定页面的内容列表,数据填充
	 * 默认查询第一页内容,一页20个
	 * <p>Title: toXingGan</p>
	 * <p>Description: </p>
	 * @return
	 */
	@RequestMapping("/{imageType}/list")
	public ModelAndView toXingGan(@RequestParam(defaultValue="1") int pageNum,@PathVariable int imageType){
		//查询总的数据量,返回可分页的次数.
		
		//对分页进行校验,不满足条件进行默认查询
		
		//从数据库中取出性感分类下的名称,从详细表中选出一个图片,按照时间排序.
		
		
		Integer totalPage = imageAccessServiceImpl.findTotalPageNum(imageType);
		
		if(pageNum<=0 ){
			pageNum=1;
		}else if ( pageNum >totalPage) {
			pageNum = totalPage;
		}
		//查询该页内容--从solr中获取
		
		List<ImageList> imageList = imageAccessServiceImpl.findImageList(pageNum, ImageType.getTypeName(ImageType.XING_GAN_MEI_NV));
		
		
		Map<String, Object> model  = new HashMap<String,Object>();
		
		model.put("list", imageList);
		model.put("maxPage", totalPage);
		model.put("nowPage", pageNum);
		
		//要暂时的列表页
		List<Integer> pageList = PageNumberListUtils.getPageNumList(pageNum, totalPage);
		
		model.put("pageList", pageList);
		
		return new ModelAndView("/image",model);
	}
	
	/**
	 * 获取图片详情
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
	     //要暂时的列表页
	     List<Integer> pageList = PageNumberListUtils.getPageNumList(pageNum, totalCount);
			
	     model.put("pageList", pageList);
			
		
		 return new ModelAndView("/detail",model);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
