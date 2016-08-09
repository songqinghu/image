package com.kuaikanwang.image.spider.pipeline;

import java.util.List;
import java.util.Map;

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
		//保证链接数

		for (int i = 0; i < urls.size(); i++) {
			long count = prePicmapper.findPrePicByUrl(urls.get(i));
			if(count >0){
				//已经存在,继续循环
				continue;
			}else{
				PrePic pic = new PrePic();
				
				pic.setUrl(urls.get(i));
				pic.setName(names.get(i));
				pic.setMurl(murls.get(i));
				pic.setWeb_id(CommonCacheUtil.getPreCacehInfoMap().get("webId"));
				pic.setPictype(CommonCacheUtil.getPreCacehInfoMap().get(CommonCacheUtil.PICTYPE));
				
				prePicmapper.insertPrePic(pic);
				
			}
		}
		
		
	}

	
}
