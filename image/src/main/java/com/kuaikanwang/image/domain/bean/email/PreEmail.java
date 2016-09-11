package com.kuaikanwang.image.domain.bean.email;

import java.util.Date;

public class PreEmail {

	private long pre_id;//主键
	  
	private long emailweb_id;//抓取的web站点对应的Id,对应web站点信息表,区分抓取站点的信息
	private String url;//下轮抓取的基础URL
	private int count; //该链接被抓取次数 最多抓取5次
	private Date cratedate;//抓取时的创建时间 默认当前时间
	private long flag;//标识位,是否可用 默认0 可用
	
	public long getPre_id() {
		return pre_id;
	}
	public void setPre_id(long pre_id) {
		this.pre_id = pre_id;
	}
	public long getEmailweb_id() {
		return emailweb_id;
	}
	public void setEmailweb_id(long emailweb_id) {
		this.emailweb_id = emailweb_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
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
