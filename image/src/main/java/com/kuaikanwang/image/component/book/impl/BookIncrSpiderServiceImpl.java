package com.kuaikanwang.image.component.book.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.kuaikanwang.image.component.book.BookIncrSpiderService;
import com.kuaikanwang.image.dao.BookIntroMapper;
import com.kuaikanwang.image.domain.bean.book.BookIntro;
import com.kuaikanwang.image.redis.RedisDao;
import com.kuaikanwang.image.spider.book.start.BookSpiderStart;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;

@Component
public class BookIncrSpiderServiceImpl implements BookIncrSpiderService,InitializingBean {

	private static Logger logger = LoggerFactory.getLogger(BookIncrSpiderServiceImpl.class);
	
	@Resource
	private BookIntroMapper bookIntroMapper;
	
	
	@Resource
	private PageProcessor quChapterPageProcessor;
	
	@Resource
	private Pipeline incrChapterMysqlPipeline;
	
	@Resource
	private RedisDao  redisDaoImpl;
	
	@Resource
	private BookSpiderStart bookSpiderStartImpl;
	
	
	//不停的循环爬取列表中信息和数据库中比对
	public void incrBookMonitoring(){
		
		bookSpiderStartImpl.spiderAllBookIntro(1);
		
		while(true){
			
			long start =0l;
			
			boolean flag = true;
			
			while (flag){
				
				List<BookIntro> bookIntros = bookIntroMapper.getIncrBookIntroByPage(start);
				if(bookIntros.size()==100){
					start=start+100;
				}else{
					flag=false;
				}
				
				for (BookIntro bookIntro : bookIntros) {
					
					//判断次intro_id 不存在才去爬取
					if(!redisDaoImpl.sismemberValue(CommonCacheUtil.REDIS_INCR_INTROS_SET, bookIntro.getIntro_id()+"")){
						CommonCacheUtil.getPreCacehInfoMap().put(CommonCacheUtil.BOOK_INCR_INTRO_ID+bookIntro.getBweb_id(), bookIntro.getIntro_id());
						
						Spider.
						create(quChapterPageProcessor)
						.addPipeline(incrChapterMysqlPipeline).
						addUrl(bookIntro.getUrl()).
						thread(7).run();
						
					}
					
					
				}
				
			}
			try {
				Thread.sleep(1000*60*5);
			} catch (InterruptedException e) {
				logger.error("book incr monitoring  occor error : " + e);
			}//睡眠5分钟
		}
		
		
	}
	/**
	 * 图书增量爬取部分
	 * <p>Title: incrBookSpider</p>
	 * <p>Description: </p>
	 */
	public void incrBookSpider(){
		while(true){
			try {
				//从redis中弹出最后一个元素 没有就等待-->
				String introId = redisDaoImpl.rpopByKey(CommonCacheUtil.REDIS_INCR_INTROS);
				
				if(introId !=null && introId.length()>0){
					
					
					Long count = bookSpiderStartImpl.spiderOneBookStart(Long.parseLong(introId));
					logger.warn("book incr spider introId is " + introId + "  and   spider count is : " + count);
					//爬取结束 从set中移除该元素
					redisDaoImpl.sremValueByKey(CommonCacheUtil.REDIS_INCR_INTROS_SET, introId);
					
				}else{
					//睡眠1分钟
					Thread.sleep(1000*60);
				}
				
			} catch (InterruptedException e) {
				logger.error("book incr spider occor error : " + e);
			}
			
		}
	}
	

	@Override
	public void afterPropertiesSet() throws Exception {
		
		//先清空redis中set和list的信息
		redisDaoImpl.delByKey(CommonCacheUtil.REDIS_INCR_INTROS);
		redisDaoImpl.delByKey(CommonCacheUtil.REDIS_INCR_INTROS_SET);
		
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				incrBookMonitoring();//一个线程 监控更新
				logger.warn("book incr monitoring start");
				
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				incrBookSpider(); //一个线程等待爬取
				logger.warn("book incr spider start");
				
			}
		}).start();
		                
		
	}
	
	
	
	
}
