package com.kuaikanwang.image.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.ImageAccessMapper;
import com.kuaikanwang.image.domain.result.ImageList;
import com.kuaikanwang.image.service.IndexShowService;

@Service
@Transactional
public class IndexShowServiceImpl implements IndexShowService {

	@Resource
	private ImageAccessMapper imageAccessMapper;
	
	
	/**
	 * 获取分类目录下浏览量最高的图片 用于首页展示
	 */
	public List<ImageList> getIndexImageListByType(Integer pictype){
		
		return imageAccessMapper.getIndexImageListByType(pictype);
	}
	
	
	
}
