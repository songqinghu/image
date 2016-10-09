package com.kuaikanwang.image.spider.book.start.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.BookIntroMapper;
import com.kuaikanwang.image.dao.GifAccessMapper;
import com.kuaikanwang.image.dao.PreGifMapper;
import com.kuaikanwang.image.dao.SpiderInfoMapper;
import com.kuaikanwang.image.domain.bean.book.BookIntro;
import com.kuaikanwang.image.domain.bean.gif.PreGif;
import com.kuaikanwang.image.spider.book.process.biquge.chapter.BQGChapterPageProcessor;
import com.kuaikanwang.image.spider.book.process.biquge.intro.BQGIntroPageProcessor;
import com.kuaikanwang.image.spider.book.start.BookSpiderStart;
import com.kuaikanwang.image.spider.dispatch.SpiderSelectDispatch;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;

@Service
@Transactional
public class BookSpiderStartImpl implements BookSpiderStart {

	
	

	@Resource
	private SpiderInfoMapper spiderInfoMapper;
	
	@Autowired
	private PreGifMapper preGifMapper;
	
	
	@Resource
	private SpiderSelectDispatch spiderSelectDispatchImpl;
	
	@Resource
	private GifAccessMapper gifAccessMapper;
	
	@Resource
	private PageProcessor BQGIntroPageProcessor;
	
	@Resource
	private Pipeline introMysqlPipeline;
	
	@Resource
	private PageProcessor BQGChapterPageProcessor;
	
	
	@Resource
	private BookIntroMapper bookIntroMapper;
	
	public Long bookSpiderStart(long bwebId){
		
		
		List<String> list = spiderInfoMapper.findBookWebSpiderUrl(bwebId);//url 和 类别
		
		/**
		 * 图书简介爬取
		 */
		for (String url : list) {
			
//			spiderSelectDispatchImpl.callPreGifSpider(bwebId, url);
			Spider.
			create(BQGIntroPageProcessor)
			.addPipeline(introMysqlPipeline).
			addUrl(url).
			thread(7).run();
			
		}
		/**
		 * 章节目录爬取	
		 */
		 //取出未完全爬取过目录的图书进行爬取
		List<BookIntro> bookIntros = bookIntroMapper.findBookIntroByIsSpider();
		for (BookIntro bookIntro : bookIntros) {
			Spider.
			create(BQGChapterPageProcessor)
			.addPipeline(new ConsolePipeline()).
			addUrl(bookIntro.getUrl()).
			thread(7).run();
		}
		
		
		
		
		/**
		 * 章节内容爬取
		 */
//		Long max = preGifMapper.findMaxNumberByWebId(bwebId);
//		long start = 0;
//		long spiderCount = 0;
//		Map<String, Long> map = new HashMap<String,Long>();
//		map.put("webId", bwebId);
//		
//		while(max>start){
//			map.put("start", start);
//			
//			PreGif gif = preGifMapper.findPreGifByWebId(map);
//			//这个需要加入一个判断 --如果mainpic中已经有pre_id了就跳过 --二次抓取提升速度---做hashcode 部分重复抓取
//			Integer count = gifAccessMapper.findDetailTotalCount((int) gif.getPre_id());
//			boolean flag = false;
//			if((gif.getCount()<6 && count <=0) || RandomUtils.nextInt(100)%99==0){
//				flag =true;
//			}
//			
//			if(flag){ //未抓取过再去抓取
//				//纪录抓取的数量
//				spiderCount++;
//				
//				//preid和pictype加入缓存中
//				CommonCacheUtil.getMainCacheInfo().put(CommonCacheUtil.GPRE_ID+bwebId, gif.getPre_id());
//				
//
//				spiderSelectDispatchImpl.callMaicGifSpider(bwebId, gif.getUrl());
//
//				preGifMapper.UpdateSpiderCountByPreId(gif.getPre_id());
//			}
//		
//			start = start + 1;
//			
//		}
//		return spiderCount;
		return 0l;
	}
}
