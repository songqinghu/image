package com.kuaikanwang.image.dao;

public interface LookCountMapper {
	
	/**
	 * 查询表中是否存在数据
	 * <p>Title: findPreInfoByPid</p>
	 * <p>Description: </p>
	 * @param pid
	 * @return
	 */
	public Integer findPreInfoByPid(Long pid);
	
	/**
	 * 插入统计信息
	 * <p>Title: insertLookCountInfo</p>
	 * <p>Description: </p>
	 * @param pid
	 */
	public void insertLookCountInfo(Long pid);
	/**
	 * 更新统计信息
	 * <p>Title: updateLookCountInfo</p>
	 * <p>Description: </p>
	 * @param pid
	 */
	public void updateLookCountInfo(Long pid);
	

}
