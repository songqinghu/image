package com.kuaikanwang.image.service;

import java.util.List;

import com.kuaikanwang.image.domain.bean.AppVersion;
import com.kuaikanwang.image.domain.result.AppImageInfo;

public interface AppSimpleShowService {

	
	public Integer findTotalPageNum(int pageSize);
	
	public List<AppImageInfo> findImageByPage(int pageNum,int pageSize);
	
	
	public AppVersion versionCheck();
}
