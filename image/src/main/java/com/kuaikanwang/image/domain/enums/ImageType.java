package com.kuaikanwang.image.domain.enums;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
/**
 * 图片分类对应关系表
 * <p>Title: ImageType.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年7月20日下午11:21:05
 * @version 1.0
 */
public class ImageType {

	
	public static final Integer XING_GAN_MEI_NV = 1;//性感美女
	public static final Integer QING_CHUN_MEI_MEI = 2;
	public static final Integer MEI_NV_XIAO_HUA = 3;
	public static final Integer XING_GAN_CHE_MO = 4;
	public static final Integer QING_PAO_MEI_NV = 5;
	public static final Integer MING_XING_XIE_ZHEN = 6;
	
	
	public static Map<Integer, String> ImageType = new HashMap<Integer,String>();
	
	private  static boolean flag = false;
	
	/**
	 * 获取类型名称
	 * <p>Title: getTypeName</p>
	 * <p>Description: </p>
	 * @param type
	 * @return
	 */
	public static  String  getTypeName(Integer type){
		
		if(!flag){//初始化
			init();
			flag = true;
		}
		
		return ImageType.get(type);
	}
	
	
	private static void init(){
		ImageType.put(1, "性感美女");
		ImageType.put(2, "清纯美眉");
		ImageType.put(3, "美女校花");
		ImageType.put(4, "性感车模");
		ImageType.put(5, "旗袍美女");
		ImageType.put(6, "明星写真");
	}
	
	
}
