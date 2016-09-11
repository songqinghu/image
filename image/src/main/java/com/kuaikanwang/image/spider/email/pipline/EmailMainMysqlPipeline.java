package com.kuaikanwang.image.spider.email.pipline;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.kuaikanwang.image.dao.MainEmailMapper;
import com.kuaikanwang.image.domain.bean.email.MainEmail;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
@Repository("emailMainMysqlPipeline")
public class EmailMainMysqlPipeline implements Pipeline{

	
	@Resource
	private MainEmailMapper mainEmailMapper;
	
	//将爬取到的真实图片地址存放在数据库中
	@Override
	public void process(ResultItems resultItems, Task task) {
		
		
		Map<String, Object> all = resultItems.getAll();
		
		List<String> emails = (List<String>) all.get("emails");
		
		//webid
		Long emailwebId = (Long) all.get(CommonCacheUtil.WEB_ID);
		
		
	    for (String em : emails) {
				
			    MainEmail email  = new MainEmail();
			   
			    email.setEmail(em.trim());
			    email.setEmailweb_id(emailwebId);
			    email.setPre_id(CommonCacheUtil.getMainCacheInfo().get(CommonCacheUtil.EMAILPRE_ID+emailwebId));
				synchronized(this){
					
					long count = mainEmailMapper.findMainEmailByEmail(em);
					
					if(count <= 0){
						mainEmailMapper.insertMainEmail(email);
					}
				}
	    } 

			
	}

}
