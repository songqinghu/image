package com.kuaikanwang.image.spider.book.process.biquge.content;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kuaikanwang.image.spider.website.WebSiteIdentification;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
/**
 * 图书内容抓取测试类
 * <p>Title: DemoIntroPageProcessor.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年10月2日下午8:40:03
 * @version 1.0
 */
@Component("BQGContentPageProcessor")
public class BQGContentPageProcessor implements PageProcessor,WebSiteIdentification {
	
    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.
    		me().
    		setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36ss").
    		setRetryTimes(5).setSleepTime(1000);

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来

        List<String> contents = page.getHtml().
                xpath("//div[@class='nr_nr']/div/text()")
                .regex("\\S+")
                .all();

    	//List<String> all3 = page.getHtml().links().regex("http://www\\.mm131\\.com/xinggan/(\\d+)\\.html").all();
    	//()代表取出其中的数据
//    	for (String string : all2) {
//			System.out.println(string);
//		}
    	///uploads/allimg/160830/2-160S00031030-L.jpg
    	//http://www.youqu.net/uploads/allimg/160830/2-160S00031030-L.jpg
//    	List<String> murls = page.getHtml().
//    	xpath("//div[@class='container']/div/div[@class='NEWS']/div/div/div[@class='new-img']/ul/li/a/img")
//    	.regex("src=\"\\s*((http://)?.+\\.(jpg|gif|png))\\s*\"",1)
//     	.replace("^/uploads","http://www.youqu.net/uploads")
//    	.all();
    	

    	
    	page.putField(CommonCacheUtil.WEB_ID, getWebId());
    	page.putField("contents", contents);

    	 
    	if (page.getResultItems().get("contents") == null //|| page.getResultItems().get("murls") ==null 
    			) {
            //skip this page
            page.setSkip(true);
        }

       
 //       System.out.println(all3.size());
//        List<String> all2 = page.getHtml().xpath("//dd/a[@target='_blank']/text()").all();
//        for (String string : all2) {
//        	System.out.println(string);
//			
//		}

//        System.err.println("urls : " + contents.size());
//        page.addTargetRequests(all);
        	
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
