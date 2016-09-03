package com.kuaikanwang.image.service;

import java.util.List;

import com.kuaikanwang.image.domain.bean.gif.GifList;

public interface GifAccessService {

	
	public Integer findGifPageTotalByPageSize(Integer pageSize);
	
	public List<GifList> findGifListByPageNum(Integer pageNum,Integer pageSize);
}
