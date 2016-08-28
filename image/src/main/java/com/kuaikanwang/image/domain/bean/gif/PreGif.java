package com.kuaikanwang.image.domain.bean.gif;

import java.util.Date;

public class PreGif {
	
	private long pre_id;//主键
	  
	private long gweb_id;//抓取的web站点对应的Id,对应web站点信息表,区分抓取站点的信息
	private String name;//显示图片的名称
	private String url;//下轮抓取的基础URL
	private String murl;//小图片的URL,用于列表展示
	private Date cratedate;//抓取时的创建时间 默认当前时间
	private long flag;//标识位,是否可用 默认0 可用
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
	public String getMurl() {
		return murl;
	}
	public void setMurl(String murl) {
		this.murl = murl;
	}
	public Date getCratedate() {
		return cratedate;
	}
	public void setCratedate(Date cratedate) {
		this.cratedate = cratedate;
	}
	public long getFlag() {
		return flag;
	}
	public void setFlag(long flag) {
		this.flag = flag;
	}

}
