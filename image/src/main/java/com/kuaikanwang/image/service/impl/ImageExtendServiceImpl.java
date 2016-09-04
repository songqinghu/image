package com.kuaikanwang.image.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.ImageAccessMapper;
import com.kuaikanwang.image.domain.result.ImageList;
import com.kuaikanwang.image.service.ImageExtendService;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

@Service
@Transactional
public class ImageExtendServiceImpl implements ImageExtendService {

	@Autowired
	private ImageAccessMapper imageAccess;
	
	
	/**
	 * 返回指定数目的图片信息 按照时间进行降序排列
	 * <p>Title: getLatestPicList</p>
	 * <p>Description: </p>
	 * @param num
	 * @return
	 */
	public List<ImageList> getLatestPicList(Integer num){
		
		List<ImageList> list = imageAccess.getLatestPicList(num);
		
		
		for (ImageList imageList : list) {
			if(imageList.getPicName().length()>15){
				imageList.setPicName(imageList.getPicName().substring(0, 15));
			}
		}
		
		if(num ==11){ //是图片页展示
		if(CommonCacheUtil.getLatestPicListCache().isEmpty()){
			CommonCacheUtil.getLatestPicListCache().addAll(list);
		}
		CommonCacheUtil.getLatestPicList().clear();
		CommonCacheUtil.getLatestPicList().addAll(list);
		}
		return list;
	}


	/**
	 * 获取最多观看过的图片 指定数目的列表
	 * <p>Title: getCountPicList</p>
	 * <p>Description: </p>
	 * @param num
	 * @return
	 * @see com.kuaikanwang.image.service.ImageExtendService#getCountPicList(java.lang.Integer)
	 */
	@Override
	public List<ImageList> getCountPicList(Integer num) {
		
		List<ImageList> list = imageAccess.getCountPicList(num);
		
		
		for (ImageList imageList : list) {
			if(imageList.getPicName().length()>15){
				imageList.setPicName(imageList.getPicName().substring(0, 15));
			}
		}
		
		if(num ==10){ //是图片页面展示
		if(CommonCacheUtil.getCountPicListCache().isEmpty()){
			CommonCacheUtil.getCountPicListCache().addAll(list);
		}
		CommonCacheUtil.getCountPicList().clear();
		CommonCacheUtil.getCountPicList().addAll(list);
		}
		return list;
	}

	/**
	 * 获取最大的pid
	 * <p>Title: getMaxPic</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.kuaikanwang.image.service.ImageExtendService#getMaxPic()
	 */
	@Override
	public Integer getMaxPic() {
		
		Integer maxPid = imageAccess.getMaxPid();
		
		CommonCacheUtil.setMaxPid(maxPid);
		
		return maxPid;
	}
	
	
	
	
}
