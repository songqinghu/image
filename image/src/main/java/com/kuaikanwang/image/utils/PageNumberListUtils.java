package com.kuaikanwang.image.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 确定jsp展示的列表页
 * <p>Title: PageNumberListUtils.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年7月22日下午9:27:52
 * @version 1.0
 */
public class PageNumberListUtils {

	
	/**
	 * 根据当前页和最大页数确定展示的列表---默认展示9页
	 * <p>Title: getPageNumList</p>
	 * <p>Description: </p>
	 * @param nowPage
	 * @param maxPage
	 * @return
	 */
	public static List<Integer> getPageNumList(Integer nowPage,Integer maxPage){
		List<Integer> pageNum = new ArrayList<Integer>();
		
		if(nowPage<5){
			if(maxPage>=9){
				for (int i = 1; i <=9; i++) {
					pageNum.add(i);
				}
			}else{
				for (int i = 1; i <=maxPage; i++) {
					pageNum.add(i);
				}
			}
		}else if (nowPage+5 > maxPage) {
			
			for (int i = maxPage - 8; i <=maxPage; i++) {
				pageNum.add(i);
			}
		}else{
			
			for (int i = -4; i <=4; i++) {
				pageNum.add((nowPage + i));
			}
			
		}
		return pageNum;
	}
	
	
}
