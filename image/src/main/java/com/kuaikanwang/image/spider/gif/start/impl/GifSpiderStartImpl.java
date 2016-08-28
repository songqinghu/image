package com.kuaikanwang.image.spider.gif.start.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.GifAccessMapper;
import com.kuaikanwang.image.dao.ImageAccessMapper;
import com.kuaikanwang.image.dao.PreGifMapper;
import com.kuaikanwang.image.dao.PrePicMapper;
import com.kuaikanwang.image.dao.SpiderInfoMapper;
import com.kuaikanwang.image.domain.bean.PrePic;
import com.kuaikanwang.image.domain.bean.gif.PreGif;
import com.kuaikanwang.image.spider.dispatch.SpiderSelectDispatch;
import com.kuaikanwang.image.spider.gif.start.GifSpiderStart;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.pipeline.Pipeline;

@Service
@Transactional
public class GifSpiderStartImpl implements GifSpiderStart{

	
	
	@Resource
	private SpiderInfoMapper spiderInfoMapper;
	
	@Autowired
	private PreGifMapper preGifMapper;
	
	
	@Resource
	private SpiderSelectDispatch spiderSelectDispatchImpl;
	
	@Resource
	private GifAccessMapper gifAccessMapper;
	
	public Long preSpiderStart(long gwebId){
		
		
//		List<String> list = spiderInfoMapper.findGWebSpiderPreUrl(gwebId);//url 和 类别
//		
//		/**
//		 * 预抓取
//		 */
//		for (String url : list) {
//			
//			spiderSelectDispatchImpl.callPreGifSpider(gwebId, url);
//			
//		}
			

		/**
		 * 正式抓取
		 */
		Long max = preGifMapper.findMaxNumberByWebId(gwebId);
		long start = 0;
		long spiderCount = 0;
		Map<String, Long> map = new HashMap<String,Long>();
		map.put("webId", gwebId);
		
		while(max>start){
			map.put("start", start);
			
			PreGif gif = preGifMapper.findPreGifByWebId(map);
			//这个需要加入一个判断 --如果mainpic中已经有pre_id了就跳过 --二次抓取提升速度
			Integer count = gifAccessMapper.findDetailTotalCount((int) gif.getPre_id());
			if(count<=0){ //未抓取过再去抓取
				//纪录抓取的数量
				spiderCount++;
				
				//preid和pictype加入缓存中
				CommonCacheUtil.getMainCacheInfo().put(CommonCacheUtil.GPRE_ID+gwebId, gif.getPre_id());
				

				spiderSelectDispatchImpl.callMaicGifSpider(gwebId, gif.getUrl());

				
			}
		
			start = start + 1;
			
		}
		return spiderCount;
	}
	
}
