package com.kuaikanwang.image.utils.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.kuaikanwang.image.dao.ImageTypeMapper;
import com.kuaikanwang.image.domain.bean.ImageType;
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
@Component
public class CommonCacheUtil implements InitializingBean{

	@Resource
	private ImageTypeMapper ImageTypeMapper;
	
	public static final String  WEB_ID = "webId";
	public static final String  PICTYPE = "pictype";
	public static final String  PRE_ID = "pre_id";
	
	
	private static Map<String, Long> preCacheInfo = new HashMap<String,Long>();
	
	
	public static Map<String, Long>  getPreCacehInfoMap(){
		return preCacheInfo;
	}
	
	//图片类型缓存 --初始化从 数据库中获取
	private static Map<Long,String > imageTypeNameCache = new HashMap<Long,String>();


	public static Map<Long, String> getImageTypeNameCache() {
		return imageTypeNameCache;
	}

	
	//类别名称及类型 存入list中 前端取用
	
	private static List<ImageType> imageTypeList  = new ArrayList<ImageType>();
	
	public static List<ImageType> getImageTypeList() {
		return imageTypeList;
	}





	/**
	 * 
	 * <p>Title: afterPropertiesSet</p>
	 * <p>Description: </p>
	 * @throws Exception
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		
		/**
		 * 缓存图片类型到本地
		 */
		List<Map<String, Object>> allImageType = ImageTypeMapper.findImageType();
		
		for (Map<String, Object> map : allImageType) {
			
			ImageType type = new ImageType();
			
			Long imageType = (Long) map.get("id");
			
			String typeName = (String) map.get("typename");
			
			getImageTypeNameCache().put(imageType, typeName);
			
			type.setImageType(imageType);
			type.setTypeName(typeName);
			imageTypeList.add(type);
		}
		
		
		
	}
	
	
	
	
	
}
