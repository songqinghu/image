package com.kuaikanwang.image.dao;

import java.util.Map;

import com.kuaikanwang.image.domain.bean.email.PreEmail;
import com.kuaikanwang.image.domain.bean.gif.PreGif;

public interface PreEmailMapper {

	/**
	 * 通过url查询个数
	 * <p>Title: findPreEmailByUrl</p>
	 * <p>Description: </p>
	 * @return
	 */
	public  long  findPreEmailByUrl(String url);
	
	
	
	/**
	 * 插入数据到数据库中
	 */
	public void insertPreEmail(PreEmail preEmail);
	
	
	
	/**
	 * 查询最大个数
	 */
	public Long findMaxNumberByWebId(Long emailwebId);
	
	
	/**
	 * 根据web_id获取指定的信息
	 */
	public PreEmail findPreEmailByWebId(Map<String, Long> map);
	
	/**
	 * 根据pre_id 修改 抓取次数 +1
	 */
	public void updatePreEmailByCount(PreEmail email);
	
}
