package com.kuaikanwang.image.spider.cto.start.impl;

import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.SpiderInfoMapper;
import com.kuaikanwang.image.spider.cto.start.CTOPreSpiderStart;

@Service
@Transactional
public class CTOPreSpiderStartImpl implements CTOPreSpiderStart {

	
	@Resource
	private SpiderInfoMapper spiderInfoMapper;
	
	public boolean preSpiderStart(long webId){
		
		
		Map<String, Long> webInfo = spiderInfoMapper.findWebSpiderPreUrl(webId);//url 和 类别
		
		Set<String> keySet = webInfo.keySet();
		
		for (String key : keySet) {
			
			System.out.println("url : " + key + " pictype: " + webInfo.get(key));
			
		}
		
		
		return false;
	}
	
	
}
