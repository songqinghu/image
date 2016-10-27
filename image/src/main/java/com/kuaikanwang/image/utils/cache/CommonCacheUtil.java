package com.kuaikanwang.image.utils.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuaikanwang.image.dao.ImageTypeMapper;
import com.kuaikanwang.image.domain.bean.ImageType;
import com.kuaikanwang.image.domain.result.ImageList;
import com.kuaikanwang.image.service.ImageExtendService;
import com.kuaikanwang.image.service.impl.ImageExtendServiceImpl;
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
	
	@Autowired
	private ImageExtendService imageExtendServiceImpl;
	
	public static final String  WEB_ID = "webId";
	public static final String  PICTYPE = "pictype";
	public static final String  PRE_ID = "pre_id";
	public static final String  GPRE_ID="gpre_id";//动态图 副表preid
	public static final String  EMAILPRE_ID="emailpre_id";//邮箱 副表preid
	public static final String BOOK_INTRO_ID="book_intro_id";//图书唯一id
	public static final String BOOK_CHAPTER_ID="book_chapter_id";//图书唯一id
	public static final String BOOK_NAME="book_name";//图书唯一id
	public static final String BOOK_INCR_INTRO_ID="book_incr_intro_id";//增量部分图书intro_id
	public static final String REDIS_INCR_INTROS="redis_incr_intros";//增量存在redis中的图书列表
	public static final String REDIS_INCR_INTROS_SET="redis_incr_intros_set";//增量存在redis中的图书列表
	
	
	private static Map<String, Long> preCacheInfo = new HashMap<String,Long>();
	
	
	public static Map<String, Long>  getPreCacehInfoMap(){
		return preCacheInfo;
	}

	//主抓取信息缓存
	private static Map<String, Long> mainCacheInfo = new HashMap<String,Long>();
	
	public static Map<String, Long> getMainCacheInfo() {
		return mainCacheInfo;
	}

	private static Map<String, String> bookContentCache = new HashMap<String,String>();
	
	public static Map<String, String> getBookContentCache() {
		return bookContentCache;
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


	//缓存 最新图片信息到内存中 使用定时器 定时更新
	private static List<ImageList> latestPicList =  new ArrayList<ImageList>();
	private static List<ImageList> latestPicListCache =  new ArrayList<ImageList>();
	
	public static List<ImageList> getLatestPicList() {

		if(latestPicList.isEmpty()){
			return latestPicListCache;
		}
		return latestPicList;
	}

	public static List<ImageList> getLatestPicListCache() {
		return latestPicListCache;
	}


	//缓存 最新图片信息到内存中 使用定时器 定时更新
	private static List<ImageList> countPicList =  new ArrayList<ImageList>();
	private static List<ImageList> countPicListCache =  new ArrayList<ImageList>();

	public static List<ImageList> getCountPicList() {
		if(countPicList.isEmpty()){
			return countPicListCache;
		}
		return countPicList;
	}

	public static List<ImageList> getCountPicListCache() {
		return countPicListCache;
	}
	
	private static Integer  maxPid ;
	
	public static Integer getMaxPid() {
		return maxPid;
	}

	public static void setMaxPid(Integer maxPid) {
		CommonCacheUtil.maxPid = maxPid;
	}

	//缓存分类对应最大可用图片数目
	private static Map<Integer,Integer > typeCountCache = new HashMap<Integer,Integer>();
	
	public static Map<Integer, Integer> getTypeCountCache() {
		return typeCountCache;
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
		
		imageExtendServiceImpl.getLatestPicList(11);
		
		imageExtendServiceImpl.getCountPicList(10);
		
		imageExtendServiceImpl.getMaxPic();
		
		
		bookTypeCache.put(1l, "玄幻奇幻");
		bookTypeCache.put(2l, "武侠仙侠");
		bookTypeCache.put(3l, "都市言情");
		bookTypeCache.put(4l, "青春校园");
		bookTypeCache.put(5l, "穿越架空");
		bookTypeCache.put(6l, "惊悚悬疑");
		bookTypeCache.put(7l, "历史军事");
		bookTypeCache.put(8l, "游戏竞技");
		bookTypeCache.put(9l, "耽美同人");
		 
		
	}
	
	//主抓取信息缓存
	private static Map<Long,String> bookTypeCache = new HashMap<Long,String>();
	
	public static Map<Long,String> getBookTypeCache() {
		return bookTypeCache;
	}
	
	
	
}
