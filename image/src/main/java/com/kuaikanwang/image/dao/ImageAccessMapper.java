package com.kuaikanwang.image.dao;

import java.util.List;
import java.util.Map;

import com.kuaikanwang.image.domain.query.ImageQuery;
import com.kuaikanwang.image.domain.result.AppImageInfo;
import com.kuaikanwang.image.domain.result.DetailImage;
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

	/**
	 * 当前类目下的条目数
	 * <p>Title: getTotalPage</p>
	 * <p>Description: </p>ss
	 * @param type
	 * @return
	 */
	public int  getTotalPage(Integer type);
	
	/**
	 * 获取展示的指定分类下的图片列表 按照时间进行排序 分页
	 * <p>Title: getImageList</p>
	 * <p>Description: </p>
	 * @param query
	 * @return
	 */
	public List<ImageList> getImageList(ImageQuery query);
	
	
	public Integer findDetailTotalCount(Integer pid);
	
	
	public DetailImage getDetailImage(Map<String, Integer> map);
	
	

	/**
	 * 查询库中所有可以展示的图片数目
	 * <p>Title: getImageCount</p>
	 * <p>Description: </p>
	 * @return
	 */
	public int  getImageCountNum();
	
	/**
	 * 分页展示图片
	 */
	public List<AppImageInfo> findImageByPage(ImageQuery query);
	
	
	
}
