package com.kuaikanwang.image.spider.cto.main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class CTOMainProcessor implements PageProcessor{

	   // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
	
    private static  int pre_id;

    public static int getPre_id() {
		return pre_id;
	}

	public static void setPre_id(int x) {
		pre_id = x;
	}

	@Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        // 部分二：定义如何抽取页面信息，并保存下来
		//http://www.2cto.com/meinv/uploads/allimg/160407/1-16040G05321.jpg
		//regex("(http://img1\\.mm131\\.com/pic/\\d+/\\d+\\.jpg)")
		//http://www.2cto.com/meinv/uploads/allimg/160606/1-160606152I2.jpg
    	List<String> urls = page.getHtml().xpath("//div[@class='big-pic']/div[@id='big-pic']/a/img")
    			.regex("src=(.+)").replace("\"","").replace(">", "").all();
    	//"http://www.2cto.com/meinv/uploads/allimg/160606/1-160606152I5.jpg ">
    	
    	List<String> names = page.getHtml().xpath("//div[@id='content']/div[@class='title']/h1/text()").all();
    	//()代表取出其中的数据

    	page.putField("url", urls);
    	page.putField("name",names);
    	
    	if (page.getResultItems().get("url") == null||page.getResultItems().get("name")==null) {
            //skip this page
            page.setSkip(true);
        }

        
        // 部分三：从页面发现后续的url地址来抓取  //2506_3.html
        //List<String> all = page.getHtml().css("div.list-pic").links().regex("\\d+\\_\\d+\\.html").all();
    	//1738_1.html
    	List<String> all = page.getHtml().xpath("//div[@class='cont']/ul/li/div/a").links().regex("\\d+\\_\\d+\\.html").all();
       
        page.addTargetRequests(all);
        	
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

    	HashMap<String, String> cache = new HashMap<String,String>();
    	//从数据库中 循环取出链接进行爬取
    	int start = 1;
    	int limit = 1;
    	String sql = "select url,pre_id from ctoprepic where pre_id BETWEEN ? and ?";
    	PreparedStatement ps;
    	
    	while(start<=1635){
    		
    	
        try {
			ps = null;
					//ConnectionUtils.getConnection().prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, start+limit-1);
			start = start  + limit;
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				String url = rs.getString(1);
				if(!cache.containsKey(url)){
					//做个缓存过滤 要是抓过了就不要抓了
					int pre_id = rs.getInt(2);
					setPre_id(pre_id);
					Spider.create(new CTOMainProcessor()).addUrl(url).addPipeline(new CTOMainMysqlPipeline())
					//开启5个线程抓取
					.thread(10)
					//启动爬虫
					.run();
					cache.put(url, "");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	}
    	System.out.println(start);
    	System.out.println("ends"); 
    }

}
