package com.kuaikanwang.image.spider.cto.start.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.SpiderInfoMapper;
import com.kuaikanwang.image.spider.cto.pre.CTOPageProcessorTest;
import com.kuaikanwang.image.spider.cto.pre.CTOPreMysqlPipeline;
import com.kuaikanwang.image.spider.cto.start.CTOPreSpiderStart;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

@Service
@Transactional
public class CTOPreSpiderStartImpl implements CTOPreSpiderStart {

	
	@Resource
	private SpiderInfoMapper spiderInfoMapper;
	
	public boolean preSpiderStart(long webId){
		
		
		List<Map<String, Object>> list = spiderInfoMapper.findWebSpiderPreUrl(webId);//url 和 类别
		
		for (Map<String, Object> map : list) {
			String url = (String) map.get("url");
			Long pictype = (Long) map.get("pictype");
			System.out.println("开始 : " + url);
			long start = System.currentTimeMillis();
			Spider.create(new CTOPageProcessorTest()).addPipeline(new CTOPreMysqlPipeline()).
			addUrl(url).
			thread(7).run();
			System.out.println(System.currentTimeMillis() - start + " 结束 :" + url);
		}
		
		
		return false;
	}
	
	
}
