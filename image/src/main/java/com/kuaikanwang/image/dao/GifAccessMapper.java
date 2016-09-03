package com.kuaikanwang.image.dao;

import java.util.List;

import com.kuaikanwang.image.domain.bean.gif.GifList;
import com.kuaikanwang.image.domain.query.ImageQuery;

public interface GifAccessMapper {

	
	/**
	 * 获取maingif表中 指定pid 对应 图片的个数
	 * <p>Title: findDetailTotalCount</p>
	 * <p>Description: </p>
	 * @param pid
	 * @return
	 */
	public Integer findDetailTotalCount(Integer pid);
	
	
	/**
	 * 获取 maingif 表中 动态图数目 
	 * <p>Title: findGifPageTotal</p>
	 * <p>Description: </p>
	 * @return
	 */
	public Integer findGifPageTotal();
	
	
	/**
	 * 根据 pageSize 和 pageNum
	 */
	public List<GifList> findGifListShow(ImageQuery query);
	
	
}
