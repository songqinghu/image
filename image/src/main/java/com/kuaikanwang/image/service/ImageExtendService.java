package com.kuaikanwang.image.service;

import java.util.List;

import com.kuaikanwang.image.domain.result.ImageList;

public interface ImageExtendService {

	
	public List<ImageList> getLatestPicList(Integer num);
	
	public List<ImageList> getCountPicList(Integer num);
	
	public Integer  getMaxPic();
	
}
