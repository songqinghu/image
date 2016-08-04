package com.kuaikanwang.image.dao;

import java.util.List;
import java.util.Map;

/**
 * 爬虫相关信息获取
 * <p>Title: SpiderInfoMapper.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年7月27日下午11:06:56
 * @version 1.0
 */
public interface ImageTypeMapper {
	
	/**
	 * 查询全部的分类信息
	 * <p>Title: findImageType</p>
	 * <p>Description: </p>
	 * @return
	 */
	public List<Map<String, Object>> findImageType();
	
	

}
