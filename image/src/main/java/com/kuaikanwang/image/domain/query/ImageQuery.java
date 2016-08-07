package com.kuaikanwang.image.domain.query;

public class ImageQuery {

	
	private Integer start;
	
	private Integer rows  =20;
	
	private Integer pictype;
	
	private Integer pid;

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPictype() {
		return pictype;
	}

	public void setPictype(Integer pictype) {
		this.pictype = pictype;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}
}
