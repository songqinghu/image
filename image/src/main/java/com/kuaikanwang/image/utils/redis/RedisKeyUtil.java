package com.kuaikanwang.image.utils.redis;
/**
 * 获取指定的key
 * <p>Title: RedisKeyUtil.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年9月3日下午11:58:49
 * @version 1.0
 */
public class RedisKeyUtil {

	/**
	 * 一级限制
	 * <p>Title: getSpiderOneKey</p>
	 * <p>Description: </p>
	 * @param key
	 * @return
	 */
	public static String getSpiderOneKey(String key){
		
		return "spider_one_"+key;
	}
	
	
	/**
	 * 二级限制
	 * <p>Title: getSpiderOneKey</p>
	 * <p>Description: </p>
	 * @param key
	 * @return
	 */
	public static String getSpiderTwoKey(String key){
		
		return "spider_two_"+key;
	}
	
	
	/**
	 * blacklist 黑名单
	 * <p>Title: getSpiderOneKey</p>
	 * <p>Description: </p>
	 * @param key
	 * @return
	 */
	public static String getSpiderBlackListKey(String key){
		
		return "spider_blacklist_"+key;
	}
	
	
	
}
