package com.kuaikanwang.image.spider.email.pipline;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kuaikanwang.image.dao.PreEmailMapper;
import com.kuaikanwang.image.domain.bean.email.PreEmail;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Repository("emailPreMysqlPipeline")
public class EmailPreMysqlPipeline implements Pipeline{


	private static Logger Logger = LoggerFactory.getLogger(EmailPreMysqlPipeline.class);
	
	
	@Autowired
	private PreEmailMapper preEmailMapper;
	
	@Override
	public void process(ResultItems resultItems, Task task) {

		Map<String, Object> all = resultItems.getAll();
		//下次抓取的列表地址
		List<String> urls = (List<String>) all.get("urls");
		
		//获取webid
		Long emailwebId = (Long) all.get(CommonCacheUtil.WEB_ID);
		
		//保证链接数
		
		for (int i = 0; i < urls.size(); i++) {
			String url = urls.get(i);
			PreEmail email = new PreEmail();
			Logger.info("pre email get url is :{}" + url);
			email.setUrl(url);

			email.setEmailweb_id(emailwebId);
			
			synchronized(this){
				
				long count = preEmailMapper.findPreEmailByUrl(url);
				if(count >0){
					//已经存在,继续循环
					continue;
				}else{
					preEmailMapper.insertPreEmail(email);
					
				}
				
			}
		}
		
		
	}
}
