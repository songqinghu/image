package com.kuaikanwang.image.spider.souutu.pre;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kuaikanwang.image.spider.website.WebSiteIdentification;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
@Component("souutuPrePageProcessor")
public class SouutuPrePageProcessor  implements PageProcessor,WebSiteIdentification{

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(500);
	

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来

    	List<String> urls = page.getHtml().
    			xpath("//ul[@class='l-meinv-wrapp cl']/li/div[@class='title']").links().all();
    			//regex("(http://www\\.souutu\\.com/mnmm/.+/.+.html)")
    	
    	List<String> names = page.getHtml()
    			.xpath("//ul[@class='l-meinv-wrapp cl']/li/div[@class='title']/a/text()").all();
    	//http://img.souutu.com/2016/0809/20160809062207927.jpg.234.360.jpg
    	List<String> murls = page.getHtml().
    			xpath("//ul[@class='l-meinv-wrapp cl']/li/div[@class='timg']/a/img")
    	.regex("http://img\\.souutu\\.com/.+/.+/.+\\.jpg\\.234\\.360\\.jpg").all();
    	
    	page.putField(CommonCacheUtil.WEB_ID, getWebId());
    	page.putField("urls", urls);
    	page.putField("murls", murls);
    	page.putField("names",names);
    	 
    	if (page.getResultItems().get("urls") == null || page.getResultItems().get("murls") ==null ) {
            //skip this page
            page.setSkip(true);
        }

        
        // 部分三：从页面发现后续的url地址来抓取 // /mnmm/xgmm/index_2.html
        List<String> all = page.getHtml().
        		xpath("//div[@class='souutu-listpage cl']/div[@class='sumlist']/a").
        		links().regex("http://www\\.souutu\\.com/mnmm/.+/index\\_.+\\.html")
        		.all();

        page.addTargetRequests(all);
        	
    }

    @Override
    public Site getSite() {
        return site;
    }

	@Override
	public long getWebId() {
		return 3;
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
//    	Spider.create(new SouutuPrePageProcessor()).
//    	addUrl("http://www.souutu.com/mnmm/mnmx/")
//    	.addPipeline(new ConsolePipeline()).
//    	thread(10).run();
//    	
//	}
    

}
