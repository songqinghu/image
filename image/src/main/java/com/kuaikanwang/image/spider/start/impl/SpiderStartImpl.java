package com.kuaikanwang.image.spider.start.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.ImageAccessMapper;
import com.kuaikanwang.image.dao.PrePicMapper;
import com.kuaikanwang.image.dao.SpiderInfoMapper;
import com.kuaikanwang.image.domain.bean.PrePic;
import com.kuaikanwang.image.spider.cto.main.CTOMainProcessor;
import com.kuaikanwang.image.spider.cto.pre.CTOPageProcessorTest;
import com.kuaikanwang.image.spider.mm131.main.MMMainPageProcessor;
import com.kuaikanwang.image.spider.mm131.pre.MMPrePageProcessor;
import com.kuaikanwang.image.spider.start.SpiderStart;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;

@Service
@Transactional
public class SpiderStartImpl implements SpiderStart {

	
	@Resource
	private SpiderInfoMapper spiderInfoMapper;
	
	@Resource
	private Pipeline preMysqlPipeline;
	
	
	@Autowired
	private PrePicMapper prePicmapper;
	
	
	@Autowired
	private Pipeline mainMysqlPipeline;
	
	@Resource
	private ImageAccessMapper imageAccessMapper;
	
	public Long preSpiderStart(long webId){
		
		
		List<Map<String, Object>> list = spiderInfoMapper.findWebSpiderPreUrl(webId);//url 和 类别
		
		CommonCacheUtil.getPreCacehInfoMap().put(CommonCacheUtil.WEB_ID, webId);
		
		/**
		 * 预抓取
		 */
		for (Map<String, Object> map : list) {
			String url = (String) map.get("url");
			Long pictype = (Long) map.get("pictype");
			
			CommonCacheUtil.getPreCacehInfoMap().put(CommonCacheUtil.PICTYPE, pictype);
			
			if(webId ==1){
				Spider.create(new CTOPageProcessorTest()).addPipeline(preMysqlPipeline).
				addUrl(url).
				thread(7).run();
			}else if(webId ==2){
				Spider.create(new MMPrePageProcessor()).addPipeline(preMysqlPipeline).
				addUrl(url).
				thread(7).run();
			}
		}
		/**
		 * 正式抓取
		 */
		Long max = prePicmapper.findMaxNumberByWebId(webId);
		long start = 0;
		long spiderCount = 0;
		Map<String, Long> map = new HashMap<String,Long>();
		map.put("webId", webId);
		
		while(max>start){
			map.put("start", start);
			
			PrePic pic = prePicmapper.findPrePicByWebId(map);
			//这个需要加入一个判断 --如果mainpic中已经有pre_id了就跳过 --二次抓取提升速度
			Integer count = imageAccessMapper.findDetailTotalCount((int) pic.getPre_id());
			
			if(count<=0){ //未抓取过再去抓取
				//纪录抓取的数量
				spiderCount++;
				
				//preid和pictype加入缓存中
				CommonCacheUtil.getPreCacehInfoMap().put(CommonCacheUtil.PRE_ID, pic.getPre_id());
				CommonCacheUtil.getPreCacehInfoMap().put(CommonCacheUtil.PICTYPE, pic.getPictype());
				
				if(webId ==1){
					
					Spider.create(new CTOMainProcessor()).addPipeline(mainMysqlPipeline)
					.addUrl(pic.getUrl()).thread(7).run();
					
				}
				else if (webId ==2) {
					Spider.create(new MMMainPageProcessor()).addPipeline(mainMysqlPipeline)
					.addUrl(pic.getUrl()).thread(7).run();
				}
					
				
			}
		
			start = start + 1;
			
		}
		return spiderCount;
	}
	
	
}
