package com.kuaikanwang.image.dao;

import java.util.List;

import com.kuaikanwang.image.domain.query.ImageQuery;
import com.kuaikanwang.image.domain.result.ImageList;

/**
 * 图片访问
 * <p>Title: ImageAccessMapper.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年7月21日下午9:02:59
 * @version 1.0
 */
public interface ImageAccessMapper {

	
	public int getTotalPage(String typeName);
	
	public List<ImageList> getImageList(ImageQuery query);
	
	
	
	
}
