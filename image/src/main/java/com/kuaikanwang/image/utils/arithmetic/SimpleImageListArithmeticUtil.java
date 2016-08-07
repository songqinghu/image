package com.kuaikanwang.image.utils.arithmetic;

/**
 * 简单的图片算法 --获取一个推荐的pid
 * <p>Title: SimpleImageListArithmeticUtil.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年8月7日下午4:38:22
 * @version 1.0
 */
public class SimpleImageListArithmeticUtil {

	
	public static Integer getRecommendPid(Integer max,Integer nowPid){
		
		return Math.abs((max+1)/2 - nowPid);//一个大于等于0的数字
	}
	
	
}
