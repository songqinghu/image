package com.kuaikanwang.image.domain.bean.book;
/**
 * 图书初始爬取信息
 * <p>Title: BookSpiderInfo.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年10月27日下午11:00:19
 * @version 1.0
 */
public class BookSpiderInfo {

	private Long booktype;
	
	private String url;

	public Long getBooktype() {
		return booktype;
	}

	public void setBooktype(Long booktype) {
		this.booktype = booktype;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
