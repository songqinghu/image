package image.test.spider.baidu;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kuaikanwang.image.spider.website.WebSiteIdentification;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;


public class TiebaPrePageProcessor implements PageProcessor,WebSiteIdentification {
	
    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.
    		me().
    		setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36ss").
    		setRetryTimes(5).setSleepTime(5000);

    
    
    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来

    	
    	List<String> urls = page.getHtml().
		  xpath("//div[@class='s_post_list']/div/span/a").
		  links().
		  all();

//    	for (String url : urls) {
//			System.out.println(url);
//		}
    	
    	page.putField(CommonCacheUtil.WEB_ID, getWebId());
    	page.putField("urls", urls);

    	 
    	if (page.getResultItems().get("urls") == null) {
            //skip this page
            page.setSkip(true);
        }

       
        // 部分三：从页面发现后续的url地址来抓取
        List<String> all = page.getHtml().
        		xpath("//div[@class='wrap1']/div[@class='wrap2']/div/div/a")
        		.links()
        		.regex("http://tieba\\.baidu\\.com/f/search/res.+")
        		.all();

        page.addTargetRequests(all);
        	
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
		//String url = "http://www.meizitu.com/";
		String url = "http://tieba.baidu.com/f/search/res?ie=utf-8&kw=&qw=%26quot%3B%40qq.com%20%E6%A5%BC%E4%B8%BB%26quot%3B&rn=30&un=&sm=1";
		Spider.create(new TiebaPrePageProcessor()).addPipeline(new ConsolePipeline()).addUrl(url).
		thread(7).run();
	}
    
}
