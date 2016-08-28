package com.kuaikanwang.image.spider.dispatch;

public interface SpiderSelectDispatch {
	
	/**
	 * 调用预处理过程爬虫
	 * <p>Title: callPreSpider</p>
	 * <p>Description: </p>
	 * @param webId
	 * @return
	 */
	public boolean callPreSpider(long webId,String url);
	

	
	/**
	 * 调用主处理过程爬虫
	 * <p>Title: callMainSpider</p>
	 * <p>Description: </p>
	 * @param webId
	 * @return
	 */
	public boolean callMainSpider(long webId,String url);
	
	
	/**
	 * 调用预处理爬虫爬取动态图
	 * <p>Title: callPreGifSpider</p>
	 * <p>Description: </p>
	 * @param gwebId
	 * @param url
	 * @return
	 */
	public boolean callPreGifSpider(long gwebId,String url);
	
	/**
	 * 调用主处理处理爬虫爬取动态图
	 * <p>Title: callMaicGifSpider</p>
	 * <p>Description: </p>
	 * @param gwebId
	 * @param url
	 * @return
	 */
	public boolean callMaicGifSpider(long gwebId,String url);
	
	
}
