package com.kuaikanwang.image.spider.gif.pipeline;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuaikanwang.image.dao.PreGifMapper;
import com.kuaikanwang.image.domain.bean.gif.PreGif;
import com.kuaikanwang.image.spider.pipeline.PreMysqlPipeline;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component("gifPreMysqlPipeline")
public class GifPreMysqlPipeline implements Pipeline{

	private static Logger Logger = LoggerFactory.getLogger(PreMysqlPipeline.class);
	
	@Autowired
	private PreGifMapper preGifmapper;
	
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
		Long gwebId = (Long) all.get(CommonCacheUtil.WEB_ID);
		
		//保证链接数
		
		int size = Math.min(urls.size(), Math.min(names.size(),murls.size()));
		
		for (int i = 0; i < size; i++) {
			PreGif gif = new PreGif();
			Logger.info("pre gif get name is :{}" + names.get(i));
			gif.setUrl(urls.get(i));
			gif.setName(names.get(i));
			gif.setMurl(murls.get(i));
			gif.setGweb_id(gwebId);
			
			synchronized(this){
				long count = preGifmapper.findPreGifByUrl(urls.get(i));
				if(count >0){
					//已经存在,继续循环
					continue;
				}else{
					preGifmapper.insertPreGif(gif);
					
				}
				
			}
		}
		
		
	}

}
