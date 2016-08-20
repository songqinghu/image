package image.test.spider.test;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kuaikanwang.image.spider.website.WebSiteIdentification;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;


public class DemoPrePageProcessor implements PageProcessor,WebSiteIdentification {
	
    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(5).setSleepTime(1000);
	

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来
       // page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
     //   page.putField("url", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
    	
    	//page.putField("url", page.getHtml().links().regex("(http://img1\\.mm131\\.com/pic/\\w+/\\w+.jpg)").all());
    	
    //	List<String> all2 = page.getHtml().css("div.main").links().regex("(http://www\\.mm131\\.com/xinggan/\\d+\\.html)").all();
    	List<String> urls = page.getHtml().xpath("//dl[@class='list-left public-box']").links().regex("(http://www\\.mm131\\.com/\\w+/\\d+\\.html)").all();
    	List<String> names = page.getHtml().xpath("//dl[@class='list-left public-box']/dd/a[@target='_blank']/text()").all();
    	
    	//List<String> all3 = page.getHtml().links().regex("http://www\\.mm131\\.com/xinggan/(\\d+)\\.html").all();
    	//()代表取出其中的数据
//    	for (String string : all2) {
//			System.out.println(string);
//		}
    	
    	List<String> murls = page.getHtml().xpath("//dl[@class='list-left public-box']/dd/a/img").
    	regex("http://img1\\.mm131\\.com/pic/.+/.+\\.jpg").all();
    	
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
        List<String> all = page.getHtml().css("dd.page").links().regex("list\\_\\w+\\_\\w+\\.html").all();
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
		return 2;
	}
    
	public static void main(String[] args){
		String url = "http://www.meizitu.com/";
		Spider.create(new DemoPrePageProcessor()).addPipeline(new ConsolePipeline()).addUrl(url).thread(5).run();
	}
    
}
