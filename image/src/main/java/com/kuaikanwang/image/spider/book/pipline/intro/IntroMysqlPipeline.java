package com.kuaikanwang.image.spider.book.pipline.intro;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuaikanwang.image.dao.BookIntroMapper;
import com.kuaikanwang.image.dao.PreGifMapper;
import com.kuaikanwang.image.domain.bean.book.BookIntro;
import com.kuaikanwang.image.domain.bean.gif.PreGif;
import com.kuaikanwang.image.spider.pipeline.PreMysqlPipeline;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component("introMysqlPipeline")
public class IntroMysqlPipeline implements Pipeline{

	private static Logger Logger = LoggerFactory.getLogger(PreMysqlPipeline.class);
	
	@Autowired
	private BookIntroMapper bookIntroMapper;
	
	@Override
	public void process(ResultItems resultItems, Task task) {
		
//		webId:	1
//		url:	[http://m.biquge.com/booklist/21470.html]
//		name:	[不朽凡人]
//		author:	[鹅是老五]
//		type:	[修真小说]
//		img:	[http://www.biquge.com/files/article/image/22/21470/21470.jpg]

		Map<String, Object> all = resultItems.getAll();
		//章节列表
		List<String> urls = (List<String>) all.get("url");
		//图书名称
		List<String> names = (List<String>) all.get("name");
		//图书作者
		List<String> authors = (List<String>) all.get("author");
		//图书类型
		List<String> types = (List<String>) all.get("type");
		//图书图片---放在七牛云上 需要研究一下如何放上去和获取
		List<String> imgs = (List<String>) all.get("img");
		//图书简介 --取的是html
		List<String> introInfos = (List<String>) all.get("introInfo");
		
		//获取webid
		Long webId = (Long) all.get(CommonCacheUtil.WEB_ID);
		
		//保证链接数
		
			BookIntro bookIntro = new BookIntro();
			Logger.info("book get name is :{}" + names.get(0));
			bookIntro.setAuthor(authors.get(0));
			bookIntro.setBooktype(types.get(0));
			bookIntro.setBweb_id(webId);
			bookIntro.setName(names.get(0));
			bookIntro.setUrl(urls.get(0));
			bookIntro.setOld_pic_url(imgs.get(0));
			bookIntro.setIntroInfo(introInfos.get(0));
			synchronized(this){
				long count = bookIntroMapper.findBookByUrl(urls.get(0));
				if(count >0){
					//已经存在,继续循环
					return ;
				}else{
					bookIntroMapper.insertBookIntro(bookIntro);
					
				}
				
			}
		
		
	}

}
