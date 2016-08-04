package com.kuaikanwang.image.domain.result;

import java.util.Date;

/**
 * 列表页展示信息
 * <p>Title: ImageList.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年7月21日下午10:25:21
 * @version 1.0
 */
public class ImageList {

	private Integer mid;
	
	
	private Integer pid;//分类id 用于从表获取图片
	
	
	private String picName;
	
	
	private String picUrl;
	
	
	private Date createdate;
	
	
	private Long pictype;


	public Integer getMid() {
		return mid;
	}


	public void setMid(Integer mid) {
		this.mid = mid;
	}


	public Integer getPid() {
		return pid;
	}


	public void setPid(Integer pid) {
		this.pid = pid;
	}


	public String getPicName() {
		return picName;
	}


	public void setPicName(String picName) {
		this.picName = picName;
	}


	public String getPicUrl() {
		return picUrl;
	}


	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}


	public Date getCreatedate() {
		return createdate;
	}


	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}


	public Long getPictype() {
		return pictype;
	}


	public void setPictype(Long pictype) {
		this.pictype = pictype;
	}

	
}
