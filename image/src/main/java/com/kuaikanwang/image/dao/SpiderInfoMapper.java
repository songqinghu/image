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
public interface SpiderInfoMapper {
	
	
	public List<Map<String, Object>> findWebSpiderPreUrl(long webId);
	
	
	public List<Long> findAllWebIds();
	
	/**
	 * 获取要爬取的动态图的地址
	 * <p>Title: findGWebSpiderPreUrl</p>
	 * <p>Description: </p>
	 * @param gwebId
	 * @return
	 */
	public List<String> findGWebSpiderPreUrl(long gwebId);
	
	
	public List<Long> findGifAllWebIds();
	
	
	/**
	 * 获取要爬取的贴吧地址
	 * <p>Title: findEmailWebSpiderPreUrl</p>
	 * <p>Description: </p>
	 * @param emailwebId
	 * @return
	 */
	public List<String> findEmailWebSpiderPreUrl(long emailwebId);
	
	
	public List<Long> findEmailAllWebIds();
	
	
	
	/**
	 * 获取要爬取的动态图的地址
	 * <p>Title: findGWebSpiderPreUrl</p>
	 * <p>Description: </p>
	 * @param gwebId
	 * @return
	 */
	public List<String> findBookWebSpiderUrl(long bwebId);
	

	public List<Long> findBookAllWebIds();
	
	
	
	
	
}
