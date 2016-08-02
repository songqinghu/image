package com.kuaikanwang.image.utils.cache;

import java.util.HashMap;
import java.util.Map;
/**
 * 通用缓存类---用于缓存平时常用的元素--设置定时清理后读取
 * <p>Title: CommonCacheUtil.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年7月25日下午10:47:45
 * @version 1.0
 */
public class CommonCacheUtil {

	public static final String  WEB_ID = "webId";
	public static final String  PICTYPE = "pictype";
	
	private static Map<String, Long> preCacheInfo = new HashMap<String,Long>();
	
	
	public static Map<String, Long>  getPreCacehInfoMap(){
		return preCacheInfo;
	}
	
}
