package com.kuaikanwang.image.spider.cto.pre;

import java.util.List;

import org.springframework.stereotype.Component;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
/**
 * 
 * 抓取站点: http://www.2cto.com
 * 第一次抓取 
 * 抓取每张图片的url地址和名称
 */
@Component("ctoPrePageProcessor")
public class CTOPrePageProcessor implements PageProcessor {

	
	private Site site = Site.me().setRetryTimes(4).setSleepTime(500);
	
	
	@Override
	public void process(Page page) {

		
		//抓取到的图片url
		List<String> murls = page.getHtml().
				xpath("//div[@class='pic-list mb20 list']/ul/li/div[@class='picbox']/img").
				regex("http://www\\.2cto\\.com/meinv/uploads/.*235x350").all();
		
		//列表地址
		List<String> urls = page.getHtml().xpath("//div[@class='pic-list mb20 list']/ul/li/div[@class='name']").links().all();
		
		//for (String url : urls) {
		//	System.out.println(url);
		//}
		
		List<String> names = page.getHtml().xpath("//div[@class='pic-list mb20 list']/ul/li/div[@class='name']/a/text()").all();
		
		//for (String name : names) {
		//	System.out.println(name);
		//}
		
		page.putField("urls", urls);
		page.putField("names", names);
		page.putField("murls", murls);
		
		if(urls==null ||urls.size()==0){
			System.err.println("跳过!");
			page.setSkip(true);
		}
		
		//System.out.println(urls.size() + " : " + names.size());
		//抓取循环 list_1_2.html
		List<String> requests = page.getHtml().css("div.pages").links().regex("list\\_\\d+\\_\\d+\\.html").all();
		//ArrayList<String> newUrls = new ArrayList<String>();
		
		
		//for (String target : requests) {
		
		//	target =  CTOMeunListUtils.getUrls()+ target;
			
		//	System.out.println("下次列表: "+ target);
	  // }
		//添加下次抓取的链接列表
		page.addTargetRequests(requests);
		
		
		
	}

	@Override
	public Site getSite() {
		return site;
	}

	
}
