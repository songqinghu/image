package com.kuaikanwang.image.spider.start.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.ImageAccessMapper;
import com.kuaikanwang.image.dao.PrePicMapper;
import com.kuaikanwang.image.dao.SpiderInfoMapper;
import com.kuaikanwang.image.domain.bean.PrePic;
import com.kuaikanwang.image.spider.cto.main.CTOMainProcessor;
import com.kuaikanwang.image.spider.cto.pre.CTOPrePageProcessor;
import com.kuaikanwang.image.spider.dispatch.SpiderSelectDispatch;
import com.kuaikanwang.image.spider.dispatch.impl.SpiderSelectDispatchImpl;
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
	
	@Autowired
	private PrePicMapper prePicmapper;
	
	@Resource
	private Pipeline preMysqlPipeline;
	
//	@Autowired
//	private Pipeline mainMysqlPipeline;
	
	@Resource
	private SpiderSelectDispatch spiderSelectDispatchImpl;
	
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
			
			//加入站点信息 --思考多线程实现
			CommonCacheUtil.getPreCacehInfoMap().put(CommonCacheUtil.PICTYPE+webId, pictype);
			
			
			spiderSelectDispatchImpl.callPreSpider(webId, url);

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
			boolean flag = false;
			if((pic.getCount()<6 &&count <=0) || RandomUtils.nextInt(31)%30==0){
				flag =true;
			}
			if(flag){ //未抓取过再去抓取
				//纪录抓取的数量
				spiderCount++;
				
				//preid和pictype加入缓存中
				CommonCacheUtil.getMainCacheInfo().put(CommonCacheUtil.PRE_ID+webId, pic.getPre_id());
				CommonCacheUtil.getMainCacheInfo().put(CommonCacheUtil.PICTYPE+webId, pic.getPictype());
				
				spiderSelectDispatchImpl.callMainSpider(webId, pic.getUrl());
				
				prePicmapper.UpdateSpiderCountByPreId(pic.getPre_id());
				
			}
		
			start = start + 1;
			
		}
		return spiderCount;
	}
	
	
}
