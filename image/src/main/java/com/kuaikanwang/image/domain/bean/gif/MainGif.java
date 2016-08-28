package com.kuaikanwang.image.domain.bean.gif;

import java.util.Date;

public class MainGif {
	
	private long id;
	private long pre_id;//副表id
	private long gweb_id;// 站点id
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
	public long getGweb_id() {
		return gweb_id;
	}
	public void setGweb_id(long gweb_id) {
		this.gweb_id = gweb_id;
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
