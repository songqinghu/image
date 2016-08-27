package com.kuaikanwang.image.service;

import java.util.List;

import com.kuaikanwang.image.domain.result.ImageList;

public interface MWebAccessService {
	
	
	public Integer findTotalPageNumByImageType(Integer imageType,Integer pageSize);
	
	
	public List<ImageList> findMWebImageList(Integer pageNum ,Integer imageType);
	
	
	public List<ImageList> findImageListByPid(Long pid);

}
