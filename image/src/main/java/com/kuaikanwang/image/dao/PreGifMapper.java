package com.kuaikanwang.image.dao;

import java.util.Map;

import com.kuaikanwang.image.domain.bean.gif.PreGif;

public interface PreGifMapper {
	
	/**
	 * 通过url查询个数
	 * <p>Title: findPrePicByUrl</p>
	 * <p>Description: </p>
	 * @return
	 */
	public  long  findPreGifByUrl(String url);
	
	/**
	 * 插入数据到数据库中
	 */
	public void insertPreGif(PreGif preGif);

	
	/**
	 * 根据web_id获取指定的信息
	 */
	public PreGif findPreGifByWebId(Map<String, Long> map);
	
	
	/**
	 * 查询最大个数
	 */
	public Long findMaxNumberByWebId(Long webId);

}
