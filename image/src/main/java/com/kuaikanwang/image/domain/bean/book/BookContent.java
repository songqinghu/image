package com.kuaikanwang.image.domain.bean.book;
/**
 * 图书内容
 * <p>Title: BookContent.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年10月12日下午11:40:47
 * @version 1.0
 */
public class BookContent {
//
//	  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '章节内容,主键id',
//	  `intro_id` bigint(20) NOT NULL COMMENT '图书id,关联图书表',
//	  `chapter_id` bigint(20) DEFAULT NULL COMMENT '章节id关联章节表',
//	  `name` varchar(100) DEFAULT NULL COMMENT '章节标题',
//	  `content` MEDIUMBLOB DEFAULT NULL COMMENT '详情页展示名称',

	private long id;
	
	private long intro_id;
	
	private long chapter_id;
	
	private String name;
	
	private byte[] content;

	
	private String showContent;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIntro_id() {
		return intro_id;
	}

	public void setIntro_id(long intro_id) {
		this.intro_id = intro_id;
	}

	public long getChapter_id() {
		return chapter_id;
	}

	public void setChapter_id(long chapter_id) {
		this.chapter_id = chapter_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getShowContent() {
		return showContent;
	}

	public void setShowContent(String showContent) {
		this.showContent = showContent;
	}

	
}
