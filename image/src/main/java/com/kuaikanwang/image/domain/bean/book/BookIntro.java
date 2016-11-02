package com.kuaikanwang.image.domain.bean.book;
/**
 * 图书简介
 * <p>Title: BookIntro.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年10月8日下午11:34:42
 * @version 1.0
 */
public class BookIntro {

	private long intro_id;
	private long bweb_id;
    private String 	name;  
    private String 	author;  
    private String 	booktype;  
    private String 	url;  
    private String 	newchapter;  
    private Long 	newchapterId; 
    private Long   isend;
    private String 	old_pic_url;
    private String 	show_pic_url;
    private String introInfo;
    
    private Long bookTypeNum;//图书分类 数字
    
    private Long count;
    
    private String updatedate;
    
	public Long getBookTypeNum() {
		return bookTypeNum;
	}
	public void setBookTypeNum(Long bookTypeNum) {
		this.bookTypeNum = bookTypeNum;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	public Long getIsend() {
		return isend;
	}
	public void setIsend(Long isend) {
		this.isend = isend;
	}
	public Long getNewchapterId() {
		return newchapterId;
	}
	public void setNewchapterId(Long newchapterId) {
		this.newchapterId = newchapterId;
	}
	public String getIntroInfo() {
		return introInfo;
	}
	public void setIntroInfo(String introInfo) {
		this.introInfo = introInfo;
	}
	public long getIntro_id() {
		return intro_id;
	}
	public void setIntro_id(long intro_id) {
		this.intro_id = intro_id;
	}
	public long getBweb_id() {
		return bweb_id;
	}
	public void setBweb_id(long bweb_id) {
		this.bweb_id = bweb_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBooktype() {
		return booktype;
	}
	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNewchapter() {
		return newchapter;
	}
	public void setNewchapter(String newchapter) {
		this.newchapter = newchapter;
	}
	public String getOld_pic_url() {
		return old_pic_url;
	}
	public void setOld_pic_url(String old_pic_url) {
		this.old_pic_url = old_pic_url;
	}
	public String getShow_pic_url() {
		return show_pic_url;
	}
	public void setShow_pic_url(String show_pic_url) {
		this.show_pic_url = show_pic_url;
	}
	
}
