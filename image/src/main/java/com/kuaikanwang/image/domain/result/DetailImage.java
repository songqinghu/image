package com.kuaikanwang.image.domain.result;

import java.util.Date;

/**
 * 图片详情页
 * <p>Title: DetailImage.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年7月23日下午6:59:55
 * @version 1.0
 */
public class DetailImage {

	
	private Integer id;//图片id
	
	private Integer pid;//列表Id
	
	private String picName;//图片名称
	
	private String picUrl;//图片地址
	
	
	private Date createDate;//创建时间


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
}
