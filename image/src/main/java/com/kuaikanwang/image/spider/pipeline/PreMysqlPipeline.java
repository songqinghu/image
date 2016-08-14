package com.kuaikanwang.image.spider.pipeline;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuaikanwang.image.dao.PrePicMapper;
import com.kuaikanwang.image.domain.bean.PrePic;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

//2cto 的地址预处理到 mysql数据库中
@Component("preMysqlPipeline")
public class PreMysqlPipeline implements Pipeline {

	private static Logger Logger = LoggerFactory.getLogger(PreMysqlPipeline.class);
	
	@Autowired
	private PrePicMapper prePicmapper;
	
	@Override
	public void process(ResultItems resultItems, Task task) {

		Map<String, Object> all = resultItems.getAll();
		//下次抓取的列表地址
		List<String> urls = (List<String>) all.get("urls");
		//图片名称
		List<String> names = (List<String>) all.get("names");
		//列表图片地址
		List<String> murls = (List<String>) all.get("murls");
		
		//获取webid
		Long webId = (Long) all.get(CommonCacheUtil.WEB_ID);
		
		//保证链接数
		
		int size = Math.min(urls.size(), Math.min(names.size(),murls.size()));
		
		for (int i = 0; i < size; i++) {
			long count = prePicmapper.findPrePicByUrl(urls.get(i));
			if(count >0){
				//已经存在,继续循环
				continue;
			}else{
				PrePic pic = new PrePic();
				Logger.info("pre get name is :{}" + names.get(i));
				pic.setUrl(urls.get(i));
				pic.setName(names.get(i));
				pic.setMurl(murls.get(i));
				pic.setWeb_id(webId);
				pic.setPictype(CommonCacheUtil.getPreCacehInfoMap().get(CommonCacheUtil.PICTYPE+webId));
				
				prePicmapper.insertPrePic(pic);
				
			}
		}
		
		
	}

	
}
