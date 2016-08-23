package com.kuaikanwang.image.utils.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.solr.client.solrj.impl.LBHttpSolrClient.Rsp;
import org.springframework.format.datetime.joda.MillisecondInstantPrinter;

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
		// 嫩模斯戴媛Amy火辣身材魅力写真图片第4张
		
		regex = "第\\d+张";
		Matcher matcher3 = Pattern.compile(regex).matcher(name);
		name= matcher3.replaceFirst("");
		
		return name;
	}
	
	public static void main(String[] args) {
	    String text ="头条女神张梓柔身着厨娘装，真空上阵 大胆展示完美身材(1/40)";
        String name = getBeautifulString(text);
        System.out.println(name);
    }

}
