package com.kuaikanwang.image.spider.souutu.main;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

public class SouutuMainPageProcessor  implements PageProcessor{

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(500);
	

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来

    	// http://img.souutu.com/2016/0808/20160808010503710.jpg
         List<String> urls = 
    			page.getHtml().
    			xpath("//div[@class='container ptw']/div/div/ul/li/img")
    			.regex("http://img\\.souutu\\.com/.+/.+/.+\\.jpg").all();
    	List<String> names = page.getHtml()
    			.xpath("//div[@class='meinvshow-banner cl']/div/div/h1/strong/a/text()").all();

    	
    	
    	page.putField("url", urls);
    	page.putField("name",names);
    	 
    	if (page.getResultItems().get("url") == null || page.getResultItems().get("name") ==null ) {
            //skip this page
            page.setSkip(true);
        }

        
        // 部分三：从页面发现后续的url地址来抓取 // /mnmm/xgmm/index_2.html
        List<String> all = page.getHtml().
        		xpath("//div[@class='bigpages']/div/span/a").
        		links().regex("http://www\\.souutu\\.com/mnmm/.+/.+\\_.+\\.html")
        		.all();

        page.addTargetRequests(all);
        	
    }

    @Override
    public Site getSite() {
        return site;
    }
    
    
//    public static void main(String[] args) {
//		//http://www.souutu.com/mnmm/xgmm/  45
//    	//http://www.souutu.com/mnmm/qc/    7
//    	//http://www.souutu.com/mnmm/mote/  18
//    	//http://www.souutu.com/mnmm/Mtsw/   4 
//    	//http://www.souutu.com/mnmm/fzl/    6
//    	//http://www.souutu.com/mnmm/baobei/ 3 
//    	//http://www.souutu.com/mnmm/cm/     2
//    	//http://www.souutu.com/mnmm/hgmn/   6
//    	//http://www.souutu.com/mnmm/rbmn/   6
//    	//http://www.souutu.com/mnmm/mnmx/   9
//    	Spider.create(new SouutuMainPageProcessor()).
//    	addUrl("http://www.souutu.com/mnmm/xgmm/17.html")
//    	.addPipeline(new ConsolePipeline()).
//    	thread(10).run();
//    	
//	}
    

}
