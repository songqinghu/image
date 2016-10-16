package com.kuaikanwang.image.spider.book.pipline.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuaikanwang.image.dao.BookChapterMapper;
import com.kuaikanwang.image.dao.BookContentMapper;
import com.kuaikanwang.image.dao.BookIntroMapper;
import com.kuaikanwang.image.dao.PreGifMapper;
import com.kuaikanwang.image.domain.bean.book.BookChapter;
import com.kuaikanwang.image.domain.bean.book.BookContent;
import com.kuaikanwang.image.domain.bean.book.BookIntro;
import com.kuaikanwang.image.domain.bean.gif.PreGif;
import com.kuaikanwang.image.spider.pipeline.PreMysqlPipeline;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component("contentMysqlPipeline")
public class ContentMysqlPipeline implements Pipeline{

	private static Logger Logger = LoggerFactory.getLogger(PreMysqlPipeline.class);
	
	@Autowired
	private BookContentMapper bookContentMapper;
	
	@Autowired
	private BookChapterMapper bookChapterMapper;
	
	@Override
	public void process(ResultItems resultItems, Task task) {
		
//		  `intro_id` bigint(20) NOT NULL COMMENT '图书介绍id--对应相应的书籍',
//		  `name` varchar(100) DEFAULT NULL COMMENT '章节名称',
//		  `url` varchar(100) DEFAULT NULL COMMENT '章节内容的url,对应要抓取的章节内容',
//		  `number` bigint(20) NOT NULL DEFAULT '0'  COMMENT '该章节再此本书中的位置,递增,用于排序',

		Map<String, Object> all = resultItems.getAll();
		//章节列表 url
		List<String> contents = (List<String>) all.get("contents");
		
		//获取webid
		Long webId = (Long) all.get(CommonCacheUtil.WEB_ID);
		
		Long introId = CommonCacheUtil.getMainCacheInfo().get(CommonCacheUtil.BOOK_INTRO_ID+webId);
		Long chapterId = CommonCacheUtil.getMainCacheInfo().get(CommonCacheUtil.BOOK_CHAPTER_ID+webId);
		String name = CommonCacheUtil.getBookContentCache().get(CommonCacheUtil.BOOK_NAME+webId);
		
		//保证链接数
		
			BookContent content = new BookContent();
			content.setChapter_id(chapterId);
			content.setShowContent(contents.get(0));
			content.setIntro_id(introId);
			content.setName(name);
			
			Logger.info("book content name is :{}" + name);
			
			synchronized(this){
				long count = bookContentMapper.findBookByChapterId(chapterId);
				if(count >0){
					//已经存在,继续循环
					return ;
				}else{
					bookContentMapper.insertBookContent(content);
					Map<String, Long> map = new HashMap<String,Long>();
					map.put("status", 1l);
					map.put("chapter_id", chapterId);
					bookChapterMapper.updateChapterSpiderStatus(map );
				}
				
			}
			
			
		
		
	}

}
