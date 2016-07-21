package com.kuaikanwang.image.domain.query;

public class ImageQuery {

	
	private Integer start;
	
	private Integer rows  =20;
	
	private String pictype;

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

	public String getPictype() {
		return pictype;
	}

	public void setPictype(String pictype) {
		this.pictype = pictype;
	}
}
