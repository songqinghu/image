package com.kuaikanwang.image.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.ImageAccessMapper;
import com.kuaikanwang.image.domain.query.ImageQuery;
import com.kuaikanwang.image.domain.result.ImageList;
import com.kuaikanwang.image.service.MWebAccessService;

@Service
@Transactional
public class MWebAccessServiceImpl implements MWebAccessService {

	
	@Resource
	private ImageAccessMapper imageAccessMapper;
	
	/**
	 * 通过图片类型查询主表中类型下图片数目,计算页数
	 * <p>Title: findTotalPageNumByImageType</p>
	 * <p>Description: </p>
	 * @param pageSize
	 * @return
	 * @see com.kuaikanwang.image.service.MWebAccessService#findTotalPageNumByImageType(int)
	 */
	@Override
	public Integer findTotalPageNumByImageType(Integer imageType,Integer pageSize) {
		
		 int totalCount = imageAccessMapper.getImageShowCountByImageType(imageType);//这里应该缓存
		 
		 int totalPage = ((totalCount+pageSize -1)/pageSize);
		
		 return totalPage;
	}

	/**
	 * 查询主表分类下图片  m站展示
	 * <p>Title: findMWebImageList</p>
	 * <p>Description: </p>
	 * @param pageNum
	 * @param imageType
	 * @return
	 * @see com.kuaikanwang.image.service.MWebAccessService#findMWebImageList(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<ImageList> findMWebImageList(Integer pageNum, Integer imageType) {
		
		 ImageQuery query = new ImageQuery();
		 
		 query.setPictype(imageType);
		 query.setStart((pageNum-1)*15);
		 query.setRows(15);
		 List<ImageList> imageList = imageAccessMapper.findMWebImageList(query);
		
		 return imageList;
		
	}

	@Override
	public List<ImageList> findImageListByPid(Long pid) {
		return imageAccessMapper.findImageListByPid(pid);
	}

	
	
	
	
	
}
