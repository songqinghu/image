package image.test.spider.baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.assertj.core.util.Strings.StringsToJoin;

import com.kuaikanwang.image.spider.website.WebSiteIdentification;
import com.kuaikanwang.image.utils.cache.CommonCacheUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;


public class TiebaMainPageProcessor implements PageProcessor,WebSiteIdentification {
		
	    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
	    private Site site = Site.me().
	    		setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36ss").
	    		setRetryTimes(5).setSleepTime(1000);

	    private final static Pattern emailer = Pattern.compile("\\w+?@\\w+?.com");  
	    
		@Override
	    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
	    public void process(Page page) {
			 // 部分二：定义如何抽取页面信息，并保存下来
	    	//http://img1.mm131.com/pic/2506/1.jpg
	    	//http://pic.59pic.com/2016/0809/20160809025057198.jpg
	    	List<String> urls = page.getHtml()
	    			.xpath("//div[@class='p_content']/cc/div/text()")
	    			//.regex("(\\D+(\\d+＠qq.com).+)+",2)
	    			//.links()
	    			.all();
	    	for (String string : urls) {
				//System.out.println(string.trim());

				Matcher matchr = emailer.matcher(string);  
		        while (matchr.find()) {  
		            String email = matchr.group();  
		            System.out.println(email);  
		        } 
			}
	        System.out.println("end");
	        // 部分三：从页面发现后续的url地址来抓取  //http://www.59pic.com/mn/1445_5.html
	        List<String> all = page.getHtml().
	        		xpath("//div[@class='indexbox']/div/div/div/a").
	        		links()
	        		.regex("src=\"\\s*(http://.+\\.gif)\\s*\"")
	        		.all();
	       
	      //  page.addTargetRequests(all);
	        	
	    }

	    @Override
	    public Site getSite() {
	        return site;
	    } 

		@Override
		public long getWebId() {
			return 4;
		}

//		      http://tieba.baidu.com/p/4774482092?pid=97572154367&cid=97579599789#97579599789
//			  http://tieba.baidu.com/p/4773743938?pid=97550614506&cid=0#97550614506
//			  http://tieba.baidu.com/p/4053555883?pid=90086059753&cid=97474942027#97474942027
//			  http://tieba.baidu.com/p/681974671?pid=97407819241&cid=0#97407819241
//			  http://tieba.baidu.com/p/4091086716?pid=97364151250&cid=0#97364151250
//			  http://tieba.baidu.com/p/4763531027?pid=97235649070&cid=0#97235649070
//			  http://tieba.baidu.com/p/4760721478?pid=97227613242&cid=0#97227613242
//			  http://tieba.baidu.com/p/3641373313?pid=97179023799&cid=0#97179023799
//			  http://tieba.baidu.com/p/4740337808?pid=96419708738&cid=0#96419708738
//			  http://tieba.baidu.com/p/4236835108?pid=96416026026&cid=0#96416026026
		public static void main(String[] args){
			//String url = "http://www.meizitu.com/";
			List<String> urls = new ArrayList<String>();
			urls.add("http://tieba.baidu.com/p/4774482092?pid=97572154367&cid=97579599789#97579599789");
			urls.add("http://tieba.baidu.com/p/4773743938?pid=97550614506&cid=0#97550614506");
			urls.add("http://tieba.baidu.com/p/4053555883?pid=90086059753&cid=97474942027#97474942027");
			urls.add("http://tieba.baidu.com/p/681974671?pid=97407819241&cid=0#97407819241");
			urls.add("http://tieba.baidu.com/p/4091086716?pid=97364151250&cid=0#97364151250");
			urls.add("http://tieba.baidu.com/p/4763531027?pid=97235649070&cid=0#97235649070");
			urls.add("http://tieba.baidu.com/p/4760721478?pid=97227613242&cid=0#97227613242");
			urls.add("http://tieba.baidu.com/p/3641373313?pid=97179023799&cid=0#97179023799");
			urls.add("http://tieba.baidu.com/p/4740337808?pid=96419708738&cid=0#96419708738");
			urls.add("http://tieba.baidu.com/p/4236835108?pid=96416026026&cid=0#96416026026");
			for (String url : urls) {
				//String url = "http://tieba.baidu.com/p/4773743938?pid=97550614506&cid=0#97550614506";
				Spider.create(new TiebaMainPageProcessor()).addPipeline(new ConsolePipeline()).addUrl(url).
				thread(10).run();
				
			}
		}
	    
	}