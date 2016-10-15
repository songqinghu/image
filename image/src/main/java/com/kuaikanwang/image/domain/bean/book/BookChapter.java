package com.kuaikanwang.image.domain.bean.book;
/**
 * 图书章节
 * <p>Title: BookChapter.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年10月12日下午10:22:58
 * @version 1.0
 */
public class BookChapter {
	
	private long chapter_id;
	
	private long intro_id;
	
	private String name;
	
	private String url;
	
	private long count;
	
	private long number;

	public long getChapter_id() {
		return chapter_id;
	}

	public void setChapter_id(long chapter_id) {
		this.chapter_id = chapter_id;
	}

	public long getIntro_id() {
		return intro_id;
	}

	public void setIntro_id(long intro_id) {
		this.intro_id = intro_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}
	

}
