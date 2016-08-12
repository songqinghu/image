package com.kuaikanwang.image.utils.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.solr.client.solrj.impl.LBHttpSolrClient.Rsp;

/**
 * 字符串处理工具
 * <p>Title: StringProcessUtil.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年8月7日下午6:26:17
 * @version 1.0
 */
public class StringProcessUtil {

	/**
	 * 运动宝贝傲人双峰丰满弹性诱惑美女图片照(6)（7）
	 * 将最后的 (6) 去掉
	 * <p>Title: getBeautifulString</p>
	 * <p>Description: </p>
	 * @param name
	 * @return
	 */
	public static String getBeautifulString(String name){
		
		String regex = "\\(.+\\)";
		Matcher matcher = Pattern.compile(regex).matcher(name);
		name= matcher.replaceFirst("");
		//中文处理 （7）
		regex = "\\（.+\\）";
		Matcher matcher2 = Pattern.compile(regex).matcher(name);
		name= matcher2.replaceFirst("");
		
		return name;
	}
	
	
}