package com.kuaikanwang.image.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.service.IImageAccessService;

@Service
@Transactional
public class ImageAccessServiceImpl implements IImageAccessService {

	
	
	
	/**
	 * 查询指定分类下的总页数
	 * <p>Title: findTotalPageNum</p>
	 * <p>Description: </p>
	 * @return
	 */
	public Integer findTotalPageNum(Integer type){
		
		
		return null;
	}
	
	
}
