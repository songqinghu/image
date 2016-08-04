package com.kuaikanwang.image.service;

import java.util.List;

import com.kuaikanwang.image.domain.result.DetailImage;
import com.kuaikanwang.image.domain.result.ImageList;

public interface IImageAccessService {

	public Integer findTotalPageNum(Integer type);
	
	public List<ImageList> findImageList(Integer pageNum ,Integer imageType);
	
	public Integer findTotalCount(Integer pid);
	
	
	public DetailImage getDetailImage(Integer pid,Integer pageNum);
}
