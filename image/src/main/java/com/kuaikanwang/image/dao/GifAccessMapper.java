package com.kuaikanwang.image.dao;

public interface GifAccessMapper {

	
	/**
	 * 获取maingif表中 指定pid 对应 图片的个数
	 * <p>Title: findDetailTotalCount</p>
	 * <p>Description: </p>
	 * @param pid
	 * @return
	 */
	public Integer findDetailTotalCount(Integer pid);
}
