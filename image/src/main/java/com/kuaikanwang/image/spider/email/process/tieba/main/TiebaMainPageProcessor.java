package com.kuaikanwang.image.spider.email.process.tieba.main;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.kuaikanwang.image.spider.website.WebSiteIdentification;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
@Component("tiebaMainPageProcessor")
public class TiebaMainPageProcessor implements PageProcessor,WebSiteIdentification {

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().
    		setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36ss").
    		setRetryTimes(5).setSleepTime(1500);

    private final static Pattern emailer = Pattern.compile("\\w+?@\\w+?.com");  
    
	@Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
		 // 部分二：定义如何抽取页面信息，并保存下来
    	//http://img1.mm131.com/pic/2506/1.jpg
    	//http://pic.59pic.com/2016/0809/20160809025057198.jpg
    	List<String> urls = page.getHtml()
    			.xpath("//div[@class='p_content']/cc/div/text()")
    			.all();
    	List<String> emails = new ArrayList<String>();
    	for (String string : urls) {
			Matcher matchr = emailer.matcher(string);  
	        while (matchr.find()) {  
	            String email = matchr.group().replaceAll("。", ".").toLowerCase();
	            emails.add(email);
	        } 
		}
    	
    	page.putField(CommonCacheUtil.WEB_ID, getWebId());
    	page.putField("emails", emails);

    	 
    	if (page.getResultItems().get("emails") == null) {
            //skip this page
            page.setSkip(true);
        }
    	
        // 部分三：从页面发现后续的url地址来抓取  //http://www.59pic.com/mn/1445_5.html
        List<String> all = page.getHtml().
        		xpath("//div[@class='wrap1']/div[@class='wrap2']/div/div/div/div/div/ul/li/a").
        		links()
        		.regex("http://tieba\\.baidu\\.com/p/.+")
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
}
