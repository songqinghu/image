package com.kuaikanwang.image.spider.book.start.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.BookChapterMapper;
import com.kuaikanwang.image.dao.BookIntroMapper;
import com.kuaikanwang.image.dao.GifAccessMapper;
import com.kuaikanwang.image.dao.PreGifMapper;
import com.kuaikanwang.image.dao.SpiderInfoMapper;
import com.kuaikanwang.image.domain.bean.book.BookChapter;
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
	
	@Resource
	private BookChapterMapper bookChapterMapper;
	
	@Resource
	private Pipeline chapterMysqlPipeline;
	
	@Resource
	private PageProcessor BQGContentPageProcessor;
	
	@Resource
	private Pipeline contentMysqlPipeline;
	
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
		long spiderCount = 0;
		for (BookIntro bookIntro : bookIntros) {
			
			spiderCount = spiderBookIntro(bwebId, bookIntro, spiderCount);
		}
		return spiderCount;
	}
	/**
	 * 爬取webId下的某一本书 可用于增量部分
	 * <p>Title: spiderBookIntro</p>
	 * <p>Description: </p>
	 * @param bwebId
	 * @param bookIntro
	 * @param spiderCount
	 * @return
	 */
	public Long spiderBookIntro(Long bwebId,BookIntro bookIntro,Long spiderCount){
		
		CommonCacheUtil.getPreCacehInfoMap().put(CommonCacheUtil.BOOK_INTRO_ID+bwebId, bookIntro.getIntro_id());
		
		Spider.
		create(BQGChapterPageProcessor)
		.addPipeline(chapterMysqlPipeline).
		addUrl(bookIntro.getUrl()).
		thread(7).run();
		/**
		 * 章节内容爬取
		 */
		Long max = bookChapterMapper.findMaxNumberForBookChapter();
		long start = 0;
		Map<String, Long> map = new HashMap<String,Long>();
		map.put("webId", bwebId);
		
		while(max>start){
			map.put("start", start);
			
			BookChapter chapter = bookChapterMapper.findSpiderChapter(map);
			
			spiderCount++;
			//preid和pictype加入缓存中
			CommonCacheUtil.getMainCacheInfo().put(CommonCacheUtil.BOOK_CHAPTER_ID+bwebId,chapter.getChapter_id());
			CommonCacheUtil.getMainCacheInfo().put(CommonCacheUtil.BOOK_INTRO_ID+bwebId,chapter.getIntro_id());
			CommonCacheUtil.getBookContentCache().put(CommonCacheUtil.BOOK_NAME+bwebId,chapter.getName());
			
			Spider.
			create(BQGContentPageProcessor)
			.addPipeline(contentMysqlPipeline).
			addUrl(chapter.getUrl()).
			thread(7).run();
			
//		spiderSelectDispatchImpl.callMaicGifSpider(bwebId, gif.getUrl());
			
//	    preGifMapper.UpdateSpiderCountByPreId(gif.getPre_id());
			
			start = start + 1;
			
		}
		bookChapterMapper.updateChapterIsSpider();
		
		return spiderCount;
	}
	
	
	
	
	
}
