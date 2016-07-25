package com.kuaikanwang.image.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.soap.Detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.ImageAccessMapper;
import com.kuaikanwang.image.domain.enums.ImageType;
import com.kuaikanwang.image.domain.query.ImageQuery;
import com.kuaikanwang.image.domain.result.DetailImage;
import com.kuaikanwang.image.domain.result.ImageList;
import com.kuaikanwang.image.service.IImageAccessService;

@Service
@Transactional
public class ImageAccessServiceImpl implements IImageAccessService {

	@Autowired
	private ImageAccessMapper imageAccess;
	
	
	/**
	 * 查询指定分类下的总页数
	 * <p>Title: findTotalPageNum</p>
	 * <p>Description: </p>
	 * @return
	 */
	public Integer findTotalPageNum(Integer type){
		
		 //这里加个缓存--1小时定时清理一次
		
		 int totalCount = imageAccess.getTotalPage(ImageType.getTypeName(type));
		 
		 int totalPage = ((totalCount+19)/20);
		
		 return totalPage;
	}
	
	
	
	public List<ImageList> findImageList(Integer pageNum ,String pictype){
		

		 ImageQuery query = new ImageQuery();
		 
		 query.setPictype(pictype);
		 query.setStart((pageNum-1)*20);
		 
		 List<ImageList> imageList = imageAccess.getImageList(query);
		
		 return imageList;
	}
	
	
	/**
	 * 获取指定目标图片总个数
	 * <p>Title: findTotalCount</p>
	 * <p>Description: </p>
	 * @param pid
	 * @return
	 */
	public Integer findTotalCount(Integer pid){
		
		
		
		return imageAccess.findDetailTotalCount(pid);
	}
	
	
	/**
	 * 获取指定的详情图片
	 * <p>Title: getDetailImage</p>
	 * <p>Description: </p>
	 * @param pid
	 * @param pageNum
	 * @return
	 */
	public DetailImage getDetailImage(Integer pid,Integer pageNum){
		
		Map<String, Integer> map = new HashMap<String,Integer>();
		
		map.put("pid", pid);
		map.put("pageNum", pageNum -1);
		
		return imageAccess.getDetailImage(map);
	}
	
	
	
	
	
	
	
	
	
	
}
