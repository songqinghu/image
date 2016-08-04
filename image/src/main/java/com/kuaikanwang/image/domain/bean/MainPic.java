package com.kuaikanwang.image.domain.bean;

import java.util.Date;

/**
 * 对应表 mainpic
 * <p>Title: MainPic.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年8月3日下午9:12:54
 * @version 1.0
 */
public class MainPic {

	private long id;
	private long pre_id;//副表id
	private long pictype;//图片类型
	private String name;//详情页展示名称
	private String url;//详情页图片地址
	private Date cratedate;//创建时间
	private int flag;//图片标示位 默认0 可用
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPre_id() {
		return pre_id;
	}
	public void setPre_id(long pre_id) {
		this.pre_id = pre_id;
	}
	public long getPictype() {
		return pictype;
	}
	public void setPictype(long pictype) {
		this.pictype = pictype;
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
	public Date getCratedate() {
		return cratedate;
	}
	public void setCratedate(Date cratedate) {
		this.cratedate = cratedate;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	
}
