package com.kuaikanwang.image.spider.book.incr;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuaikanwang.image.dao.BookChapterMapper;
import com.kuaikanwang.image.redis.RedisDao;
import com.kuaikanwang.image.spider.pipeline.PreMysqlPipeline;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component("incrChapterMysqlPipeline")
public class IncrChapterMysqlPipeline implements Pipeline{

	private static Logger Logger = LoggerFactory.getLogger(PreMysqlPipeline.class);
	
	@Autowired
	private BookChapterMapper bookChapterMapper;
	
	@Autowired
	private RedisDao redisDaoImpl;
	
	@Override
	public void process(ResultItems resultItems, Task task) {
		
//		  `intro_id` bigint(20) NOT NULL COMMENT '图书介绍id--对应相应的书籍',
//		  `name` varchar(100) DEFAULT NULL COMMENT '章节名称',
//		  `url` varchar(100) DEFAULT NULL COMMENT '章节内容的url,对应要抓取的章节内容',
//		  `number` bigint(20) NOT NULL DEFAULT '0'  COMMENT '该章节再此本书中的位置,递增,用于排序',

		Map<String, Object> all = resultItems.getAll();
		//章节列表 url
		List<String> urls = (List<String>) all.get("urls");
		//章节别表名称
//		List<String> names = (List<String>) all.get("names");
		
		//获取webid
		Long webId = (Long) all.get(CommonCacheUtil.WEB_ID);
		
		Long introId = CommonCacheUtil.getPreCacehInfoMap().get(CommonCacheUtil.BOOK_INCR_INTRO_ID+webId);
		
		
		Long count = bookChapterMapper.getAllBookChapterNumberByIntroId(introId);
		
		if(urls.size()>count){//有新内容 -->放在redis中 --控制重复不在这里做
			
			redisDaoImpl.lpushValue(CommonCacheUtil.REDIS_INCR_INTROS, introId+"");
			
			//还要放入set中用于去除重复
			redisDaoImpl.saddValue(CommonCacheUtil.REDIS_INCR_INTROS_SET, introId+"");
		}
		//增量写入结束
		
		
		//保证链接数
//		for (int i = 0; i < urls.size(); i++) {
//			BookChapter chapter = new BookChapter();
//			chapter.setIntro_id(introId);
//			chapter.setName(names.get(i));
//			chapter.setUrl(urls.get(i));
//			chapter.setNumber(i+1);
//			Logger.info("book chapter name is :{}" + names.get(i));
//			
//			synchronized(this){
//				long count = bookChapterMapper.findBookByUrl(chapter.getUrl());
//				if(count >0){
//					//已经存在,继续循环
//					return ;
//				}else{
//					//本书大于number的章节需要+1用于排序
//					Map<String, Long> map = new HashMap<String, Long>();
//					map.put("intro_id", chapter.getIntro_id());
//					map.put("number", chapter.getNumber());
//					bookChapterMapper.updateBookNumber(map);
//					
//					bookChapterMapper.insertBookChapter(chapter);
//				}
//				
//			}
//			
//		}
		
		
		
	}

}
