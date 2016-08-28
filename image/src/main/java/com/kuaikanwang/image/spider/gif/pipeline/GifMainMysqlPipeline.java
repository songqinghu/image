package com.kuaikanwang.image.spider.gif.pipeline;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kuaikanwang.image.dao.MainGifMapper;
import com.kuaikanwang.image.dao.MainPicMapper;
import com.kuaikanwang.image.domain.bean.MainPic;
import com.kuaikanwang.image.domain.bean.gif.MainGif;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;
import com.kuaikanwang.image.utils.string.StringProcessUtil;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component("gifMainMysqlPipeline")
public class GifMainMysqlPipeline implements Pipeline{

	@Resource
	private MainGifMapper mainGifMapper;
	
	
	//将爬取到的真实图片地址存放在数据库中
	@Override
	public void process(ResultItems resultItems, Task task) {
		
		
		Map<String, Object> all = resultItems.getAll();
		
		List<String> urls = (List<String>) all.get("url");
		List<String> names = (List<String>) all.get("name");
		
		//webid
		Long gwebId = (Long) all.get(CommonCacheUtil.WEB_ID);
		
		
		if(urls.size()>0&& names.size()>0){
			for (int i = 0; i <  urls.size(); i++) {
				MainGif gif = new MainGif();
				gif.setUrl(urls.get(i));
				gif.setName(StringProcessUtil.getBeautifulString(names.get(0)));//将最后的括号过滤掉
				gif.setPre_id(CommonCacheUtil.getMainCacheInfo().get(CommonCacheUtil.GPRE_ID+gwebId));
				gif.setGweb_id(gwebId);
				synchronized(this){
					
					long count = mainGifMapper.findMainGifByUrl(urls.get(i));
					
					if(count <= 0){
						mainGifMapper.insertMainGif(gif);
					}
				}
			}
			
		}
	}

}
