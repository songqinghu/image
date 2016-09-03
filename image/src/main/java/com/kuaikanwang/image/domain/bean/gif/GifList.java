package com.kuaikanwang.image.domain.bean.gif;

import java.util.Date;

/**
 * 列表页展示
 * <p>Title: GifList.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年9月3日上午11:01:58
 * @version 1.0
 */
public class GifList {

	private long id;
	private long pid;//副表id
	private String gifName;//详情页展示名称
	private String gifUrl;//详情页图片地址
	private Date cratedate;//创建时间
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getGifName() {
		return gifName;
	}
	public void setGifName(String gifName) {
		this.gifName = gifName;
	}
	public String getGifUrl() {
		return gifUrl;
	}
	public void setGifUrl(String gifUrl) {
		this.gifUrl = gifUrl;
	}
	public Date getCratedate() {
		return cratedate;
	}
	public void setCratedate(Date cratedate) {
		this.cratedate = cratedate;
	}
	
}
