package image.test.book.intro;

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
 * 图书简介抓取测试类
 * <p>Title: DemoIntroPageProcessor.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年10月2日下午8:40:03
 * @version 1.0
 */

public class DemoIntroPageProcessor implements PageProcessor,WebSiteIdentification {
	
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
    	 
    	if (page.getResultItems().get("url") == null //|| page.getResultItems().get("murls") ==null 
    			) {
            page.setSkip(true);
        }

    	for (String string : name) {
			System.out.println(string.trim());
		}
    	for (String string : author) {
    		System.out.println(string);
    	}
    	for (String string : type) {
    		System.out.println(string);
    	}
    	for (String string : url) {
    		System.out.println(string);
    	}
    	for (String string : img) {
    		System.out.println(string);
    	}
    	
    	for (String string : introInfo) {
			System.out.println(string);
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
//		String url = "http://m.biquge.com/21_21470/";
		String url = "http://m.biquge.com/0_202/";
		
		Spider.create(new DemoIntroPageProcessor()).addPipeline(new ConsolePipeline()).addUrl(url).
		thread(7).run();
	}
    
}
