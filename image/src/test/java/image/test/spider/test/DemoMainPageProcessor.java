package image.test.spider.test;

import java.util.List;

import com.kuaikanwang.image.spider.website.WebSiteIdentification;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;


public class DemoMainPageProcessor implements PageProcessor,WebSiteIdentification {
		
	    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
	    private Site site = Site.me().
	    		setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36ss").
	    		setRetryTimes(5).setSleepTime(1000);

		@Override
	    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
	    public void process(Page page) {
	        // 部分二：定义如何抽取页面信息，并保存下来
	    	//http://img1.mm131.com/pic/2506/1.jpg
	    	//http://img1.mm131.com/pic/2506/2.jpg
	    	List<String> urls = page.getHtml().
	    			xpath("//div[@class='main']/div[@class='content']/div[@class='main-image']/p/a/img").
	    			regex("(http://i\\.meizitu\\.net/.+/.+/.+\\.jpg)").
	    			all();
	    	
	    	
	    	List<String> names = page.getHtml().
	    			xpath("//div[@class='main']/div[@class='content']/h2/text()").
	    			all();
	    	//()代表取出其中的数据
	    	page.putField(CommonCacheUtil.WEB_ID, getWebId());
	    	page.putField("url", urls);
	    	page.putField("name",names);

	    	if (page.getResultItems().get("url") == null||page.getResultItems().get("name")==null) {
	            //skip this page
	            page.setSkip(true);
	        }

	        
	        // 部分三：从页面发现后续的url地址来抓取  //2506_3.html
	        List<String> all = page.getHtml().
	        		xpath("//div[@class='main']/div[@class='content']/div[@class='pagenavi']/a").
	        		links().
	        		regex("http://www\\.mzitu\\.com/.+/\\d+").all();
	       
	        page.addTargetRequests(all);
	        	
	    }

	    @Override
	    public Site getSite() {
	        return site;
	    }

		@Override
		public long getWebId() {
			return 4;
		}

	    
		public static void main(String[] args){
			//String url = "http://www.meizitu.com/";
			String url = "http://www.mzitu.com/72264";
			Spider.create(new DemoMainPageProcessor()).addPipeline(new ConsolePipeline()).addUrl(url).
			thread(10).run();
		}
	    
	}