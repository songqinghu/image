package com.kuaikanwang.image.spider.pipeline;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kuaikanwang.image.dao.MainPicMapper;
import com.kuaikanwang.image.domain.bean.MainPic;
import com.kuaikanwang.image.domain.bean.PrePic;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;
import com.kuaikanwang.image.utils.string.StringProcessUtil;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * 主表数据录入类结合数据库部分
 * <p>Title: MainMysqlPipeline.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年8月3日下午9:01:31
 * @version 1.0
 */
@Component("mainMysqlPipeline")
public class MainMysqlPipeline implements Pipeline{

	@Resource
	private MainPicMapper mainPicMapper;
	
	
	//将爬取到的真实图片地址存放在数据库中
	@Override
	public void process(ResultItems resultItems, Task task) {
		
		
		Map<String, Object> all = resultItems.getAll();
		
		List<String> urls = (List<String>) all.get("url");
		List<String> names = (List<String>) all.get("name");
		
		//webid
		Long webId = (Long) all.get(CommonCacheUtil.WEB_ID);
		
		
		if(urls.size()>0&& names.size()>0){
			for (int i = 0; i <  urls.size(); i++) {
				MainPic pic = new MainPic();
				
				pic.setUrl(urls.get(i));
				pic.setName(StringProcessUtil.getBeautifulString(names.get(0)));//将最后的括号过滤掉
				pic.setPre_id(CommonCacheUtil.getMainCacheInfo().get(CommonCacheUtil.PRE_ID+webId));
				pic.setPictype(CommonCacheUtil.getMainCacheInfo().get(CommonCacheUtil.PICTYPE+webId));
				
				synchronized(this){
					
					long count = mainPicMapper.findMainPicByUrl(urls.get(i));
					
					if(count <= 0){
						mainPicMapper.insertMainPic(pic);
					}
				}
			}
			
		}
	}

	
}
