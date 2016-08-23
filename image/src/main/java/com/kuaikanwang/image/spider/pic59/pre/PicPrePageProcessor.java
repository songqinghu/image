package com.kuaikanwang.image.spider.pic59.pre;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kuaikanwang.image.spider.website.WebSiteIdentification;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
@Component("picPrePageProcessor")
public class PicPrePageProcessor implements PageProcessor,WebSiteIdentification {

	   // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.
    		me().
    		setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36ss").
    		setRetryTimes(5).setSleepTime(1000);
	
    

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来

    	
    	List<String> urls = page.getHtml().
		  xpath("//div[@class='index_listc']/div/ul/li/a").
		  links().
		  all();
    	List<String> names = page.getHtml()
    			.xpath("//div[@class='index_listc']/div/ul/li/div/div/p/a/text()")
    			.all();
    	
    	//List<String> all3 = page.getHtml().links().regex("http://www\\.mm131\\.com/xinggan/(\\d+)\\.html").all();
    	//()代表取出其中的数据
//    	for (String string : all2) {
//			System.out.println(string);
//		}
    	//http://kanimg.9ku.com/pic/scimg/2016/08-16/14713330831571472121.jpg@1e_1c_0o_0l_320h_240w.src
    	List<String> murls = page.getHtml().
    			xpath("//div[@class='index_listc']/div/ul/li/a/img").
    	//regex("http://img1\\.mm131\\.com/pic/.+/.+\\.jpg")
    	regex("http://pic\\.59pic\\.com/.+\\.jpg")
    	.all();
    	
    	page.putField(CommonCacheUtil.WEB_ID, getWebId());
    	page.putField("urls", urls);
    	page.putField("murls", murls);
    	page.putField("names",names);
    	 
    	if (page.getResultItems().get("urls") == null || page.getResultItems().get("murls") ==null ) {
            //skip this page
            page.setSkip(true);
        }

       
 //       System.out.println(all3.size());
//        List<String> all2 = page.getHtml().xpath("//dd/a[@target='_blank']/text()").all();
//        for (String string : all2) {
//        	System.out.println(string);
//			
//		}

        
        // 部分三：从页面发现后续的url地址来抓取
        List<String> all = page.getHtml().
        		xpath("//div[@class='index_listc']/div[@class='bigpages']/div/span/a")
        		.links()
        		.regex("http://www\\.59pic\\.com/.+/\\d+\\.html")
        		.all();
//       for (String string : all) {
//		System.out.println(string);
//       }
        page.addTargetRequests(all);
        	
    }

    @Override
    public Site getSite() {
        return site;
    }

	@Override
	public long getWebId() {
		return 6;
	}
    
}
