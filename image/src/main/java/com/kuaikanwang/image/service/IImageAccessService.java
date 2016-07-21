package com.kuaikanwang.image.service;

import java.util.List;

import com.kuaikanwang.image.domain.result.ImageList;

public interface IImageAccessService {

	public Integer findTotalPageNum(Integer type);
	
	public List<ImageList> findImageList(Integer pageNum ,String pictype);
}
