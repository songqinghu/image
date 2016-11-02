package com.kuaikanwang.image.spider.book.start.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuaikanwang.image.dao.BookChapterMapper;
import com.kuaikanwang.image.dao.BookIntroMapper;
import com.kuaikanwang.image.dao.SpiderInfoMapper;
import com.kuaikanwang.image.domain.bean.book.BookChapter;
import com.kuaikanwang.image.domain.bean.book.BookIntro;
import com.kuaikanwang.image.domain.bean.book.BookSpiderInfo;
import com.kuaikanwang.image.spider.book.start.BookSpiderStart;
import com.kuaikanwang.image.spider.dispatch.SpiderSelectDispatch;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;

@Service
@Transactional
public class BookSpiderStartImpl implements BookSpiderStart {

	
	

	@Resource
	private SpiderInfoMapper spiderInfoMapper;
	
	@Resource
	private SpiderSelectDispatch spiderSelectDispatchImpl;
	
	
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
		
		spiderAllBookIntro(bwebId);
		
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
		Long max = bookChapterMapper.findMaxNumberForBookChapter(bookIntro.getIntro_id());
		long start = 0;
		Map<String, Long> map = new HashMap<String,Long>();
		map.put("webId", bwebId);
		
		while(max>start){
			map.put("start", start);
			map.put("intro_id", bookIntro.getIntro_id());
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
		bookChapterMapper.updateChapterIsSpider(bookIntro.getIntro_id());
		//这本书爬取完毕,需要更新最新章节 --这里考虑多个来源的图书问题
		//返回 已经爬取的isspider=2 及这本书的 number数最大的值的章节信息
		BookChapter newBookChapter = bookChapterMapper.findBookChapterMaxNumberByIntroId(bookIntro.getIntro_id());
		//获取图书简介页最新章节 比较是否相同,不同就更新
		if(newBookChapter!=null && newBookChapter.getName() !=null){
			if(!newBookChapter.getName().equals(bookIntro.getNewchapter())){
				
				bookIntro.setNewchapter(newBookChapter.getName());
				bookIntro.setNewchapterId(newBookChapter.getChapter_id());
				
				bookIntroMapper.updateNewChapter4Intro(bookIntro);
			}
		}
		
		return spiderCount;
	}
	
	/**
	 * 爬取指定webId的所有图书简介
	 * <p>Title: spiderAllBookIntro</p>
	 * <p>Description: </p>
	 * @param bwebId
	 */
	public  void spiderAllBookIntro(long bwebId){
		
		List<BookSpiderInfo> books = spiderInfoMapper.findBookWebSpiderUrl(bwebId);//url 和 类别
		
		/**
		 * 图书简介爬取
		 */
		for (BookSpiderInfo book : books) {
			
//			spiderSelectDispatchImpl.callPreGifSpider(bwebId, url);
			
			CommonCacheUtil.getBookIntroCache().put(CommonCacheUtil.BOOK_TYPE+bwebId, book.getBooktype());
			
			Spider.
			create(BQGIntroPageProcessor)
			.addPipeline(introMysqlPipeline).
			addUrl(book.getUrl()).
			thread(7).run();
			
		}
	}
	
	
	/**
	 * 根据简介id进行爬取
	 * <p>Title: spiderOneBookStart</p>
	 * <p>Description: </p>
	 * @param bookId
	 * @return
	 */
	public Long spiderOneBookStart(Long introId){
		
		BookIntro bookIntro = bookIntroMapper.findBookIntroByIntroId(introId);
		
		Long count = spiderBookIntro(bookIntro.getBweb_id(), bookIntro, 0l);
		
		return count;
	}
	
	
}
