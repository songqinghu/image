package com.kuaikanwang.image.dao;

import java.util.List;

import com.kuaikanwang.image.domain.bean.email.MainEmail;

public interface MainEmailMapper {

	
	/**
	 * 通过email 查询是否存在
	 * <p>Title: findPrePicByUrl</p>
	 * <p>Description: </p>
	 * @return
	 */
	public  long  findMainEmailByEmail(String email);
	
	/**
	 * 插入数据到数据库中
	 */
	public void insertMainEmail (MainEmail email);
	
	
	/**
	 * 获取指定范围内的email 每次10个
	 */
	public List<String> findEmailByRandge(long start);
	
	/**
	 * 查询邮箱最大数目
	 */
	public Long  findEmailMaxNum();
	
}
