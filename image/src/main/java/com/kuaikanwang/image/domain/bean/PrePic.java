package com.kuaikanwang.image.domain.bean;

import java.util.Date;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * 表 prepic
 * <p>Title: PrePic.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年8月2日下午10:06:48
 * @version 1.0
 */
public class PrePic {


	private long pre_id;//主键
			  
	private long web_id;//抓取的web站点对应的Id,对应web站点信息表,区分抓取站点的信息
	private long pictype;//图片类型,依赖图片类型表
	private String name;//显示图片的名称
	private String url;//下轮抓取的基础URL
	private String murl;//小图片的URL,用于列表展示
	private Date cratedate;//抓取时的创建时间 默认当前时间
	private long flag;//标识位,是否可用 默认0 可用
	private long count;//抓取次数
	public long getPre_id() {
		return pre_id;
	}
	public void setPre_id(long pre_id) {
		this.pre_id = pre_id;
	}
	public long getWeb_id() {
		return web_id;
	}
	public void setWeb_id(long web_id) {
		this.web_id = web_id;
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
    public long getCount() {
        return count;
    }
    public void setCount(long count) {
        this.count = count;
    }
	
}
