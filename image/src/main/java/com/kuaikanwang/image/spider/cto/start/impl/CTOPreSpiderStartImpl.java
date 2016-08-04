package com.kuaikanwang.image.spider.cto.start.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.PrePicMapper;
import com.kuaikanwang.image.dao.SpiderInfoMapper;
import com.kuaikanwang.image.domain.bean.PrePic;
import com.kuaikanwang.image.spider.cto.main.MainMysqlPipeline;
import com.kuaikanwang.image.spider.cto.main.CTOMainProcessor;
import com.kuaikanwang.image.spider.cto.pre.CTOPageProcessorTest;
import com.kuaikanwang.image.spider.cto.pre.CTOPreMysqlPipeline;
import com.kuaikanwang.image.spider.cto.start.CTOPreSpiderStart;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.Pipeline;

@Service
@Transactional
public class CTOPreSpiderStartImpl implements CTOPreSpiderStart {

	
	@Resource
	private SpiderInfoMapper spiderInfoMapper;
	
	@Resource
	private Pipeline ctoPreMysqlPipeline;
	
	
	@Autowired
	private PrePicMapper prePicmapper;
	
	
	@Autowired
	private Pipeline mainMysqlPipeline;
	
	
	public boolean preSpiderStart(long webId){
		
		
		List<Map<String, Object>> list = spiderInfoMapper.findWebSpiderPreUrl(webId);//url 和 类别
		
		CommonCacheUtil.getPreCacehInfoMap().put(CommonCacheUtil.WEB_ID, webId);
		
		/**
		 * 预抓取
		 */
		for (Map<String, Object> map : list) {
			String url = (String) map.get("url");
			Long pictype = (Long) map.get("pictype");
			
			CommonCacheUtil.getPreCacehInfoMap().put(CommonCacheUtil.PICTYPE, pictype);
			
			Spider.create(new CTOPageProcessorTest()).addPipeline(ctoPreMysqlPipeline).
			addUrl(url).
			thread(7).run();
		}
		/**
		 * 正式抓取
		 */
		Long max = prePicmapper.findMaxNumberByWebId(webId);
		long start = 0;
		
		Map<String, Long> map = new HashMap<String,Long>();
		map.put("webId", webId);
		
		while(max>start){
			map.put("start", start);
			
			PrePic pic = prePicmapper.findPrePicByWebId(map);
			
			//preid和pictype加入缓存中
			CommonCacheUtil.getPreCacehInfoMap().put(CommonCacheUtil.PRE_ID, pic.getPre_id());
			CommonCacheUtil.getPreCacehInfoMap().put(CommonCacheUtil.PICTYPE, pic.getPictype());
			
			
			Spider.create(new CTOMainProcessor()).addPipeline(mainMysqlPipeline)
			.addUrl(pic.getUrl()).thread(7).run();
		
			start = start + 1;
			
		}
		
		return true;
	}
	
	
}
