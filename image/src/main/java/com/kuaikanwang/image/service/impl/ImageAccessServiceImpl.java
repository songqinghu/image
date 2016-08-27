package com.kuaikanwang.image.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.ImageAccessMapper;
import com.kuaikanwang.image.domain.query.ImageQuery;
import com.kuaikanwang.image.domain.result.DetailImage;
import com.kuaikanwang.image.domain.result.ImageList;
import com.kuaikanwang.image.service.IImageAccessService;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

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
	public Integer findTotalPageNum(Integer type,Integer pageSize){
		
		 //这里加个缓存--1小时定时清理一次
			
		 Integer cacheCount = CommonCacheUtil.getTypeCountCache().get(type);
		 if(cacheCount!=null){
			 return ((cacheCount+pageSize -1)/pageSize);
		 }
		 int totalCount = imageAccess.getTotalPage(type);
		 
		 CommonCacheUtil.getTypeCountCache().put(type, totalCount);
		 
		 int totalPage = ((totalCount+pageSize -1)/pageSize);
		
		 return totalPage;
	}
	
	
	
	
	public List<ImageList> findImageList(Integer pageNum ,Integer imageType){
		

		 ImageQuery query = new ImageQuery();
		 
		 query.setPictype(imageType);
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


	/**
	 * 通过pid 获取指定图片的信息
	 * <p>Title: getImageListByPid</p>
	 * <p>Description: </p>
	 * @param pid
	 * @return
	 * @see com.kuaikanwang.image.service.IImageAccessService#getImageListByPid(java.lang.Integer)
	 */
	@Override
	public ImageList getImageListByPid(Integer pid,Integer pictype) {
		
		ImageQuery query  = new ImageQuery();
		
		query.setPid(pid);
		query.setPictype(pictype);
		
		return imageAccess.getImageListByPid(query  );
	}




	@Override
	public ImageList getPreviousImageByPid(Integer pid, Integer pictype) {
		
		ImageQuery query  = new ImageQuery();
		
		query.setPid(pid);
		query.setPictype(pictype);
		
		return imageAccess.getPreviousImageByPid(query  );
	}



	@Override
	public ImageList getNextImageByPid(Integer pid, Integer pictype) {
		
		ImageQuery query  = new ImageQuery();
		
		query.setPid(pid);
		query.setPictype(pictype);
		
		return imageAccess.getNextImageByPid(query  );
	}
	

	/**
	 * 获取推荐的图片列表
	 * <p>Title: getRecommendImageList</p>
	 * <p>Description: </p>
	 * @param pid
	 * @return
	 * @see com.kuaikanwang.image.service.IImageAccessService#getRecommendImageList(java.lang.Integer)
	 */
	@Override
	public List<ImageList> getRecommendImageList(Integer pid) {
		return imageAccess.getRecommendImageList(pid);
	}

	
	
	
	
	
	
	
	
	
}
