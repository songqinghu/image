package com.kuaikanwang.image.spider.email.start.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.GifAccessMapper;
import com.kuaikanwang.image.dao.PreEmailMapper;
import com.kuaikanwang.image.dao.SpiderInfoMapper;
import com.kuaikanwang.image.domain.bean.email.PreEmail;
import com.kuaikanwang.image.spider.dispatch.SpiderSelectDispatch;
import com.kuaikanwang.image.spider.email.start.EmailSpiderStart;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;
/**
 * 邮箱爬取类
 * <p>Title: EmailSpiderStartImpl.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年9月11日上午10:35:17
 * @version 1.0
 */
@Service("emailSpiderStartImpl")
@Transactional
public class EmailSpiderStartImpl implements EmailSpiderStart{

	
	@Resource
	private SpiderInfoMapper spiderInfoMapper;
	
	@Resource
	private PreEmailMapper preEmailMapper;
	
	
	@Resource
	private SpiderSelectDispatch spiderSelectDispatchImpl;
	
	@Resource
	private GifAccessMapper gifAccessMapper;
	
	
	@Override
	public Long spiderStart(long emailwebId) {
		
		List<String> list = spiderInfoMapper.findEmailWebSpiderPreUrl(emailwebId);//url 和 类别
		
		/**
		 * 预抓取
		 */
		for (String url : list) {
			
			spiderSelectDispatchImpl.callPreEmailSpider(emailwebId, url);
			
		}
			

		/**
		 * 正式抓取
		 */
		Long max = preEmailMapper.findMaxNumberByWebId(emailwebId);
		long start = 0;
		long spiderCount = 0;
		Map<String, Long> map = new HashMap<String,Long>();
		map.put("webId", emailwebId);
		
		while(max>start){
			map.put("start", start);
			
			PreEmail email = preEmailMapper.findPreEmailByWebId(map);

			//判断 如果被抓取了5次了 就直接跳过
			
			boolean flag = false;
			if(email.getCount() < 5 ){
				flag =true;
			}
			
			if(flag){ //未抓取过再去抓取
				//纪录抓取的数量
				spiderCount++;
				
				//preid和pictype加入缓存中
				CommonCacheUtil.getMainCacheInfo().put(CommonCacheUtil.EMAILPRE_ID+emailwebId, email.getPre_id());

				spiderSelectDispatchImpl.callMainEmailSpider(emailwebId, email.getUrl());
				
				//抓取后,次数加1
				preEmailMapper.updatePreEmailByCount(email);
				
			}
		
			start = start + 1;
			
		}
		return spiderCount;
	}

}
