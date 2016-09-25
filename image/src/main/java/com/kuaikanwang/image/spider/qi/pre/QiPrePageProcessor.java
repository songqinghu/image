package com.kuaikanwang.image.spider.qi.pre;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kuaikanwang.image.spider.website.WebSiteIdentification;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
@Component("qiPrePageProcessor")
public class QiPrePageProcessor  implements PageProcessor,WebSiteIdentification {

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
		  xpath("//div[@class='container']/div/div[@class='NEWS']/div/div/div[@class='new-img']/ul/li/a").
		  links().
		  all();
    	//<a href="http://www.7160.com/meinv/35991/" target="_blank" title="齐刘海蕾丝美女戴复古眼镜俏皮写真"><img src="http://img.7160.com/uploads/160923/12-160923110G1321.jpg" alt="<b>齐刘海蕾丝美女戴复古眼镜俏</b>"><br> <span class="bom_z"><b>齐刘海蕾丝美女戴复古眼镜俏</b></span></a>
    	//<a href="http://www.7160.com/meinv/35870/" title="文艺美术系美女画室调皮写">[09-21]文艺美术系美女画室调皮写</a>
    	List<String> names = page.getHtml()
    			.xpath("//div[@class='container']/div/div[@class='NEWS']/div/div/div[@class='new-img']/ul/li/a/img")
    			.regex("alt=\"(.+)\"")
    			.replace("<b>", "")
    			.replace("</b>", "")
    			.all();

    	//List<String> all3 = page.getHtml().links().regex("http://www\\.mm131\\.com/xinggan/(\\d+)\\.html").all();
    	//()代表取出其中的数据
//    	for (String string : all2) {
//			System.out.println(string);
//		}
    	///uploads/allimg/160830/2-160S00031030-L.jpg
    	//http://www.youqu.net/uploads/allimg/160830/2-160S00031030-L.jpg
    	List<String> murls = page.getHtml().
    	xpath("//div[@class='container']/div/div[@class='NEWS']/div/div/div[@class='new-img']/ul/li/a/img")
    	.regex("src=\"\\s*((http://)?.+\\.(jpg|gif|png))\\s*\"",1)
//    	.replace("^/uploads","http://www.youqu.net/uploads")
    	.all();
    	

    	
    	page.putField(CommonCacheUtil.WEB_ID, getWebId());
    	page.putField("urls", urls);
    	page.putField("murls", murls);
    	page.putField("names",names);
    	 
    	if (page.getResultItems().get("urls") == null || page.getResultItems().get("murls") ==null 
    			) {
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
        		xpath("//div[@class='container']/div/div[@class='NEWS']/div/div/div[@class='page']/a")
        		.links()
        		.regex("http://www.7160.com/.+\\.html")
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
		return 8;
	}
}
