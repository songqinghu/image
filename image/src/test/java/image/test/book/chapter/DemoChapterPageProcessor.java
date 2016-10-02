package image.test.book.chapter;

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
 * 图书目录抓取测试类
 * <p>Title: DemoIntroPageProcessor.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年10月2日下午8:40:03
 * @version 1.0
 */

public class DemoChapterPageProcessor implements PageProcessor,WebSiteIdentification {
	
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
		  xpath("//ul[@class='chapter']/li/a").
		  links().
		  all();
    	List<String> names = page.getHtml()
    			.xpath("//ul[@class='chapter']/li/a/text()")
    			.all();
    	
    	page.putField(CommonCacheUtil.WEB_ID, getWebId());
    	page.putField("urls", urls);
    	page.putField("names",names);
    	 
    	if (page.getResultItems().get("urls") == null || page.getResultItems().get("names") ==null 
    			) {
            //skip this page
            page.setSkip(true);
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
    
	public static void main(String[] args){
		//String url = "http://www.manhaoxiao.com";
		String url = "http://m.biquge.com/booklist/21470.html";
//		String url = "http://m.biquge.com/booklist/202.html";
		
		Spider.create(new DemoChapterPageProcessor()).addPipeline(new ConsolePipeline()).addUrl(url).
		thread(7).run();
	}
    
}
