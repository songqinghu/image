package com.kuaikanwang.image.service;

import java.util.List;

import com.kuaikanwang.image.domain.result.ImageList;

public interface IndexShowService {
	
	public List<ImageList> getIndexImageListByType(Integer pictype);

}
