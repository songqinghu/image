package com.kuaikanwang.image.spider.book.process.biquge.intro;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.kuaikanwang.image.spider.website.WebSiteIdentification;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
/**
 * 图书简介抓取测试类
 * <p>Title: DemoIntroPageProcessor.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年10月2日下午8:40:03
 * @version 1.0
 */
@Component("BQGIntroPageProcessor")
public class BQGIntroPageProcessor implements PageProcessor,WebSiteIdentification {
	
	private static Logger logger = LoggerFactory.getLogger(BQGIntroPageProcessor.class);
	
    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.
    		me().
    		setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36ss").
    		setRetryTimes(5).setSleepTime(1000);

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {

    	
    	List<String> name = page.getHtml()
    			.xpath("//div[@class='cover']/div/div/h2/a/text()")
    			.all();
    	List<String> author = page.getHtml()
    			.xpath("//div[@class='cover']/div/div/p/text()")
    			.regex("作者：(.+)")
    			.all();
    	List<String> type = page.getHtml()
    			.xpath("//div[@class='cover']/div/div/p/text()")
    			.regex("分类：(.+)")
    			.all();

    	List<String> url = page.getHtml().
		  xpath("//div[@class='intro']/a").
		  links().
		  all();
    	List<String> img = page.getHtml().
    			xpath("//div[@class='cover']/div/div/img")
    			.regex("src=\"\\s*((http://)?.+\\.(jpg|gif|png))\\s*\"",1)
    			.all();

    	List<String> introInfo = page.getHtml().
    			xpath("//div[@class='cover']/div[@class='intro_info']")
    			.regex("<div class=\"intro_info\">(.+)</div>")
    			.all();
    	
    	page.putField(CommonCacheUtil.WEB_ID, getWebId());
    	page.putField("url", url);
    	page.putField("name",name);
    	page.putField("author",author);
    	page.putField("type",type);
    	page.putField("img",img);
    	page.putField("introInfo", introInfo);
    	 
    	if (page.getResultItems().get("url") == null 
    			|| page.getResultItems().get("name") ==null 
    			|| page.getResultItems().get("author") ==null 
    			|| page.getResultItems().get("type") ==null 
    			|| page.getResultItems().get("img") ==null
    			|| page.getResultItems().get("introInfo") ==null
    			) {
            page.setSkip(true);
            logger.error("skip the book exist null ,check it!");
        }

    }

    @Override
    public Site getSite() {
        return site;
    }

	@Override
	public long getWebId() {
		return 1;
	}
    
}
